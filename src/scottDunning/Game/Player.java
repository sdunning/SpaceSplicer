package scottDunning.Game;

import java.util.Vector;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {
	
	public static final int LIGHT = 0;
	public static final int BALANCED = 1;
	public static final int HEAVY = 2;
	
	//Object Values//
	private int ID = -1;
	private int type = 1;
	private int posX = -100;
	private int posY = -100;
	private int health = 0;
	private int damage = 0;
	private int speed = 0;
	private Image skin = null;
	private String skinString = "";
	private Vector<Projectile> lasers = new Vector<Projectile>();
	
	public Player(int type, int posX, int posY, int health, int damage, int speed, Image skin) {
		this.type = type;     this.posX = posX;     this.posY = posY;
		this.health = health; this.damage = damage;
		this.speed = speed;   this.skin = skin;
	}
	public Player(int type, int posX, int posY, int health, int damage, int speed, String destination) throws SlickException {
		this.type = type;     this.posX = posX;     this.posY = posY;
		this.health = health; this.damage = damage;
		this.speed = speed;   this.skin = getFile(destination);
		skinString = destination;
	}
	
	//Get functions//
	public int getID()                    { return ID; }
	public int getType()                  { return type; }
	public int getPosX()                  { return posX; }
	public int getPosY()                  { return posY; }
	public int getHealth()                { return health; }
	public int getDamage()                { return damage; }
	public int getSpeed()                 { return speed; }
	public Image getSkin()                { return skin; }
	public String getSkinString()         { return skinString; }
	public Vector<Projectile> getLasers() { return lasers; }
	
	//Set functions//
	public void setID(int ID)              { this.ID = ID; }
	public void setType(int type)          { this.type = type; }
	public void setPosX(int posX)          { this.posX = posX; }
	public void setPosY(int posY)          { this.posY = posY; }
	public void setHealth(int health)      { this.health = health; }
	public void setDamage(int damage)      { this.damage = damage; }
	public void setSpeed(int speed)        { this.speed = speed; }
	public void setSkin(Image skin)        { this.skin = skin; }
	public void setSkinString(String skin) throws SlickException {
		skinString = skin; this.skin = getFile(skin);
    }
	
	public void incrementPosX()  { posX += speed; }
	public void incrementPosY()  { posY += speed; }
	public void decrementPosX()  { posX -= speed; }
	public void decrementPosY()  { posY -= speed; }
	
	public void addLaser(Projectile projectile) { lasers.add(projectile); }
	public void removeLaser(int index)          { lasers.remove(index); }
	
	private Image getFile(String destination) throws SlickException {
		Image image = new Image(destination);
		return image;
	}
	
	@Override
	public String toString() {
		return String.format("%6s : %6s : %6s : %6s : %6s : %6s : %6s : %6s\n%6d : %6d : %6d : %6d : %6d : %6d : %6d : %6s\n",
				             "ID", "Type", "PosX", "PosY", "Health", "Damage", "Speed", "Skin",
				             ID, type, posX, posY, health, damage, speed, skin.getName());
	}
}
