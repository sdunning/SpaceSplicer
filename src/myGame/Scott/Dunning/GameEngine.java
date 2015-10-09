package myGame.Scott.Dunning;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GameEngine extends BasicGame {
	
	GameController controller = null;
	Image bg =null;
	public GameEngine(String title) throws SlickException {
		super(title);
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		controller = new GameController(d.width, d.height);
	}
	
	@Override
	public void init(GameContainer container) throws SlickException {
		bg = new Image("images/background.png");
		controller.setBackground(bg);
		controller.setGameStarted(true);
		controller.createEnemy(Enemy.GRUNT);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.drawImage(controller.getBackground(), 0, 0, null);
		for(int i = 0; i < controller.getEnemies().size(); i++) {
			g.drawImage(controller.getEnemies().get(i).getSkin(),
					(float)controller.getEnemies().get(i).getPosX(),
					(float)controller.getEnemies().get(i).getPosY());
		}
		
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
