package myGame.Scott.Dunning;

import java.util.LinkedList;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GameController {
	
	private boolean gameStarted = false;
	private Image background = null;
	private String ship1 = null;
	private int width = 0, height = 0;
	private int wave = 0;
	
	
	private LinkedList<Enemy> enemies = new LinkedList<Enemy>();
	
	public GameController(int width, int height) throws SlickException {
		this.width = width; this.height = height;
		ship1 ="images/green.png";
	}
	
	public boolean getGameStarted()       { return gameStarted; }
	public Image getBackground()          { return background; }
	public LinkedList<Enemy> getEnemies() { return enemies; }
	
	public void setGameStarted(boolean gameStarted)   {this.gameStarted = gameStarted; }
	public void setBackground(Image bg)               { background = bg; }
	public void setEnemies(LinkedList<Enemy> enemies) { this.enemies = enemies; }
	
	public void createEnemy(int type) throws SlickException {
		Enemy enemy = null;
		if (type == Enemy.GRUNT) {
			enemy = new Enemy(Enemy.GRUNT, 250, 250, 1, 1, ship1);
		}
		if(type == Enemy.BRUTE) {}
		if(type == Enemy.BOSS) {}
		enemies.add(enemy);
		
	}
	public void destroyEnemy(Enemy enemy) {
		enemies.remove(enemy);
	}

}
