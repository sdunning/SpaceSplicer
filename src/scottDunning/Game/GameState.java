package scottDunning.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState extends BasicGameState{
	
	GameDataController GDC = GameDataController.getInstance();
	GameController gc = null;
	Image bg =null;
	
	public GameState() throws SlickException {}
	
	@Override
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		gc = new GameController(container.getWidth(), container.getHeight());
		bg = new Image("images/background.png");
		gc.setBackground(bg);
		gc.setGameStarted(true);
		gc.createPlayer(Player.HEAVY, "images/red.png");
		gc.createEnemy(Enemy.GRUNT);
		System.out.println(gc.getPlayer());
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		Input input = container.getInput();
		gc.fireUpdate();
		if(!gc.getPlayer().getSkinString().equals(GDC.getCurrentShip())) {
			gc.getPlayer().setSkinString(GDC.getCurrentShip());
			System.out.println("Skin Changed Successful");
		}
		
		if(input.isKeyDown(Input.KEY_A))     { gc.getPlayer().decrementPosX(); }
		if(input.isKeyDown(Input.KEY_D))     { gc.getPlayer().incrementPosX(); }
		if(input.isKeyDown(Input.KEY_W))     { gc.getPlayer().decrementPosY(); }
		if(input.isKeyDown(Input.KEY_S))     { gc.getPlayer().incrementPosY(); }
		if(input.isKeyDown(Input.KEY_SPACE)) { gc.fire(); }
		if(input.isKeyPressed(Input.KEY_P)) { sbg.enterState(1); }
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(gc.getBackground(), 0, 0, null);
		for(int i = 0; i < gc.getEnemies().size(); i++) {
			g.drawImage(gc.getEnemies().get(i).getSkin(),
					(float)gc.getEnemies().get(i).getPosX(),
					(float)gc.getEnemies().get(i).getPosY());
		}
		gc.fireDraw(g);
		
		g.drawImage(gc.getPlayer().getSkin(),
				(float)gc.getPlayer().getPosX() - ((float)gc.getPlayer().getSkin().getWidth()/2),
				(float)gc.getPlayer().getPosY() - ((float)gc.getPlayer().getSkin().getHeight()/2));
		
	}

	@Override
	public int getID() { return 2; }
	
	public GameController getGameController() { return gc;	}
}
