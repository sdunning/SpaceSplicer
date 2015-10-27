package scottDunning.Game;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Enemy {
	
	//Enemy Types//
	public static final int GRUNT = 0;
	public static final int BRUTE = 1;
	public static final int BOSS = 2;
	
	//Object Values//
	private int ID = -1;
	private int type = 0;
	private int posX = -100;
	private int posY = -100;
	private int health = 0;
	private int damage = 0;
	private Image skin = null;
	
	//Constructors//
	public Enemy() {}
	public Enemy(int type, int posX, int posY, int health, int damage, Image skin) {
		this.type = type; this.posX = posX; this.posY = posY;
		this.health = health; this.damage = damage;
		this.skin = skin;
	}
	public Enemy(int type, int posX, int posY, int health, int damage, String destination) throws SlickException {
		this.type = type; this.posX = posX; this.posY = posY;
		this.health = health; this.damage = damage;
		this.skin = getFile(destination);
	}
	
	
	//Get functions//
	public int getID()      { return ID; }
	public int getType()    { return type; }
	public int getPosX()    { return posX; }
	public int getPosY()    { return posY; }
	public int getHealth()  { return health; }
	public int getDamage()  { return damage; }
	public Image getSkin()  { return skin; }
	
	//Set functions//
	public void setID(int ID)         { this.ID = ID; }
	public void setType(int type)     { this.type = type; }
	public void setPosX(int posX)     { this.posX = posX; }
	public void setPosY(int posY)     { this.posY = posY; }
	public void setHealth(int health) { this.health = health; }
	public void setDamage(int damage) { this.damage = damage; }
	public void setSkin(Image skin)   { this.skin = skin; }
	
	private Image getFile(String destination) throws SlickException {
		Image image = new Image(destination);
		return image;
	}
	
	
	
	
	
	
}
