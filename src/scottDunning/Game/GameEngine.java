package scottDunning.Game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GameEngine extends StateBasedGame {
	
	public GameEngine(String title) throws SlickException {
		super(title);
	}
	
	public void initStatesList(GameContainer container) throws SlickException {
		this.addState(new IntroState());
		this.addState(new MenuState());
		this.addState(new GameState());
		this.addState(new ShipSelectState());
		//this.addState(new GameOverState());
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new GameEngine("Setup Test"));
		app.setDisplayMode(1200, 800, false);
		app.setAlwaysRender(true);
		app.setVSync(true);
		app.setTargetFrameRate(60);
		app.start();
	}
}
