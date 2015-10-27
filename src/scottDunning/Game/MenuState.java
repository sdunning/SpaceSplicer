package scottDunning.Game;

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

public class MenuState extends BasicGameState {
	
	private int width = 0, height = 0,
			    halfW = 0, halfH = 0,
			    hImageW = 0, hImageH = 0;
	
	private Image background = null;
	private Image play = null;
	private Image play2 = null;
	private Image options = null;
	private Image options2 = null;
	private Image chooseShip = null;
	private Image chooseShip2 = null;
	private Image quit = null;
	private Image quit2 = null;
	private Image cursor = null;
	
	private Shape playCollider = null;
	private Shape optionsCollider = null;
	private Shape chooseShipCollider = null;
	private Shape quitCollider = null;
	
	private Shape mouseCircle = null;
	private Shape infoBox = null;
	
	private boolean playDetection = false;
	private boolean optionsDetection = false;
	private boolean chooseShipDetection = false;
	private boolean quitDetection = false;

	@Override
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		width = container.getWidth(); height = container.getHeight();
		halfW = width/2; halfH = height/2;
		
		background = new Image("images/background.png");
		play = new Image("images/Play.png");
		play2 = new Image("images/Play2.png");
		options = new Image("images/Options.png");
		options2 = new Image("images/Options2.png");
		chooseShip = new Image("images/chooseShip.png");
		chooseShip2 = new Image("images/chooseShip2.png");
		quit = new Image("images/Quit.png");
		quit2 = new Image("images/Quit2.png");
		cursor = new Image("images/crosshair.png");
		//container.setMouseCursor(cursor, 0, 0);
		
		hImageW = play.getWidth()/2;
		hImageH = play.getHeight()/2;
		
		mouseCircle = new Circle(0, 0, 2);
		playCollider = new Rectangle(halfW - hImageW, (halfH - hImageH) - play.getHeight()*2, play.getWidth(), play.getHeight());
		optionsCollider = new Rectangle(halfW - hImageW, ((halfH - hImageH) - hImageH) - (hImageH)/2, options.getWidth(), options.getHeight());
		chooseShipCollider = new Rectangle(halfW - hImageW, ((halfH - hImageH) + hImageH) + (hImageH)/2, chooseShip.getWidth(), chooseShip.getHeight());
		quitCollider = new Rectangle(halfW - hImageW, (halfH - hImageH) + quit.getHeight()*2, quit.getWidth(), quit.getHeight());
		infoBox = new Rectangle(50, 50, 310, 100);
		
		
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		Input input = container.getInput();
		
		if(input.isKeyPressed(Input.KEY_P)) sbg.enterState(2);
		if(input.isKeyPressed(Input.KEY_C)) sbg.enterState(4);
		if(input.isKeyPressed(Input.KEY_O)) sbg.enterState(5);
		if(input.isKeyPressed(Input.KEY_ESCAPE)) System.exit(0);
		
		mouseCircle.setCenterX(container.getInput().getMouseX());
		mouseCircle.setCenterY(container.getInput().getMouseY());
		
		playDetection = playCollider.intersects(mouseCircle);
		optionsDetection = optionsCollider.intersects(mouseCircle);
		chooseShipDetection = chooseShipCollider.intersects(mouseCircle);
		quitDetection = quitCollider.intersects(mouseCircle);
		
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			if(playDetection) sbg.enterState(2);
			//if(optionsDetection) sbg.enterState(5);
			if(chooseShipDetection) sbg.enterState(4);
			if(quitDetection) System.exit(0);
		}
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw(0, 0);
		if(playDetection)       play2.draw(halfW - hImageW, (halfH - hImageH) - play.getHeight()*2);
		else                    play.draw(halfW - hImageW, (halfH - hImageH) - play.getHeight()*2);
		
		if(optionsDetection)    options2.draw(halfW - hImageW, ((halfH - hImageH) - hImageH) - (hImageH)/2);
		else                    options.draw(halfW - hImageW, ((halfH - hImageH) - hImageH) - (hImageH)/2);
		
		if(chooseShipDetection) chooseShip2.draw(halfW - hImageW, ((halfH - hImageH) + hImageH) + (hImageH)/2);
		else                    chooseShip.draw(halfW - hImageW, ((halfH - hImageH) + hImageH) + (hImageH)/2);
		
		if(quitDetection)       quit2.draw(halfW - hImageW, (halfH - hImageH) + quit.getHeight()*2);
		else                    quit.draw(halfW - hImageW, (halfH - hImageH) + quit.getHeight()*2);
		
		g.setColor(Color.green);
		g.draw(infoBox);
		g.setColor(Color.white);
		if(playDetection)       g.drawString("Start / Resume.                P", 50, 50);
		if(optionsDetection)    g.drawString("Change Game Settings.          O", 50, 75);
		if(chooseShipDetection) g.drawString("Choose a Ship.                 C", 50, 100);
		if(quitDetection)       g.drawString("Exit the Game.                 Esc", 50, 125);
	}

	@Override
	public int getID() { return 1; }

}
