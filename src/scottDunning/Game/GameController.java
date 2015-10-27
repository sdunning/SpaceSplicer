package scottDunning.Game;

import java.util.LinkedList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class GameController {
	
	GameDataController GDC = GameDataController.getInstance();
	//Values Initiated//
	private boolean gameStarted = false;
	private Image background = null;
	private String ship1 = null;
	private String playerShip = null;
	private int width = 0, height = 0;
	private int wave = 0;
	
	private Player player = null;
	private LinkedList<Enemy> enemies = new LinkedList<Enemy>();
	
	//Constructors//
	public GameController(int width, int height) throws SlickException {
		this.width = width; this.height = height;
		ship1 ="images/green.png";
		playerShip = "images/red.png";
		GDC.setCurrentShip(playerShip);
	}
	
	//Get Functions//
	public boolean getGameStarted()       { return gameStarted; }
	public Image getBackground()          { return background; }
	public Player getPlayer()             { return player; }
	public LinkedList<Enemy> getEnemies() { return enemies; }
	//End Get Functions//
	
	//Set Functions//
	public void setGameStarted(boolean gameStarted)   {this.gameStarted = gameStarted; }
	public void setBackground(Image bg)               { background = bg; }
	public void setPlayer(Player player)              {this.player = player; }
	public void setEnemies(LinkedList<Enemy> enemies) { this.enemies = enemies; }
	//End Set Functions//
	
	//Player Handling//
	public void createPlayer(int type, String skinDestination) throws SlickException {
		int posX = width / 2;
		int posY = height - 100;
		int health = 0;
		int damage = 0;
		int speed = 0;
		if(type == Player.LIGHT)    { health = 75; damage = 2; speed = 7; }
		if(type == Player.BALANCED) { health = 100; damage = 5; speed = 5; }
		if(type == Player.HEAVY)    { health = 125; damage = 8; speed = 3; }
		
		player = new Player(type, posX, posY, health, damage, speed, skinDestination);
	}
	
	//Enemy Handling//
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
	//End Enemy Handling//
	
	public void fire() {
		Projectile p = new Projectile(player.getSpeed() + 5, player.getDamage(),
				                      player.getPosX(), player.getPosY(), player.getDamage(),
				                      player.getDamage() * 2, GDC.getLaserColor());
		p.setShape( new Rectangle(p.getPosX() - p.getWidth()/2, p.getPosY(), p.getWidth(), p.getHeight()));
		player.addLaser(p);
		System.out.println(player.getLasers().size());
	}
	public void fireUpdate() {
		if(player.getLasers().isEmpty()) {System.out.println("Lasers is empty"); return; }
		for(int i=0; i<player.getLasers().size(); i++) {
			boolean hit = false;
			if(player.getLasers().get(i).getPosY() < -player.getLasers().get(i).getHeight() /*|| add or clause for collision*/) { player.removeLaser(i); }
			player.getLasers().get(i).getShape().setY(player.getLasers().get(i).getShape().getY() - player.getLasers().get(i).getVelocity());
			 System.out.println(player.getLasers().get(i).getShape().getY());
		}
	}
	public void fireDraw(Graphics g) {
		if(player.getLasers().isEmpty()) return;
		for(int i=0; i<player.getLasers().size(); i++) {
			g.setColor(player.getLasers().get(i).getColor());
			g.fill(player.getLasers().get(i).getShape());
		}
	}

}
