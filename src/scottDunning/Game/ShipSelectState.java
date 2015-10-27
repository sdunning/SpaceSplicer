package scottDunning.Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class ShipSelectState extends BasicGameState {
	
	GameDataController GDC = GameDataController.getInstance();
	Vector<String> paths = new Vector<String>();
	Vector<Image> ships = new Vector<Image>();
	Vector<Shape> colliders = new Vector<Shape>();
	private boolean trigger = false;
	private Shape mouseCollider = null;
	String str;
	int rowImage = 50, rowCollider = 50;
	
	private Shape selected = null;
	
	public ShipSelectState() {
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader("images/ships.txt"));
		    while((str = in.readLine()) != null) { paths.add(str); }
	    }catch (FileNotFoundException e) { e.printStackTrace(); }
		 catch (IOException f) { f.printStackTrace(); }
	}

	@Override
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		mouseCollider = new Circle(0, 0, 1);
		for(int i=0; i<paths.size(); i++) { 
			ships.add(new Image(paths.get(i)));
			if((i+1)*128 >= container.getWidth()) rowCollider += 128;
			colliders.add(new Rectangle((i*128) + 50, rowCollider, 128, 128));
		}
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		Input input = container.getInput();
		mouseCollider.setCenterX(container.getInput().getMouseX());
		mouseCollider.setCenterY(container.getInput().getMouseY());
		if(input.isKeyPressed(Input.KEY_P) || input.isKeyPressed(Input.KEY_S)) sbg.enterState(1);
		//if(input.isKeyPressed(Input.KEY_O)) sbg.enterState(5);
		if(input.isKeyPressed(Input.KEY_ESCAPE)) System.exit(0);
		
		for(int i=0; i<ships.size(); i++) {
			trigger = colliders.get(i).intersects(mouseCollider);
			if(trigger) {
				selected = colliders.get(i);
				trigger = false;
				if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
					GDC.setCurrentShip(paths.get(i));
					sbg.enterState(1);
				}
				break;
			}
		}
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		rowImage = 50;
		for(int i=0; i<ships.size(); i++) {
			if ((i+1)*128 >= container.getWidth()) rowImage += 128;
			ships.get(i).draw((i*128) + 50, rowImage, 2);
		}
		g.setColor(Color.yellow);
		if(selected != null) g.draw(selected);
	}

	

	@Override
	public int getID() { return 4; }

}
