package scottDunning.Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Shape;

public class Projectile{
	
	private int velocity = 0;
	private int damage = 0;
	private int posX = 0;
	private int posY = 0;
	private int width = 0;
	private int height = 0;
	private boolean hit = false;
	private Color color = Color.white;
	private Shape shape = null;
	
	//Basic Constructor//
	public Projectile() {}
	//Set Constructor//
	public Projectile(int velocity, int damage, int posX, int posY, int width, int height) {
		this.velocity = velocity; this.damage = damage;
		this.posX = posX;         this.posY = posY;
		this.width = width;       this.height = height;
	}
	//Set Constructor with color//
	public Projectile(int velocity, int damage, int posX, int posY, int width, int height, Color color) {
		this.velocity = velocity; this.damage = damage; 
		this.posX = posX;         this.posY = posY;
		this.width = width;       this.height = height;
		this.color = color;
	}
	
	//Get methods//
	public int getVelocity() { return velocity; }
	public int getDamage()   { return damage; }
	public int getPosX()     { return posX; }
	public int getPosY()     { return posY; }
	public int getWidth()    { return width; }
	public int getHeight()   { return height; }
	public boolean getHit()  { return hit; }
	public Color getColor()  { return color; }
	public Shape getShape()  { return shape; }
	
	//Set methods//
	public void setVelocity(int velocity) { this.velocity = velocity; }
	public void setDamage(int damage)     { this.damage = damage; }
	public void setPosX(int posX)         { this.posX = posX; }
	public void setPosY(int posY)         { this.posY = posY; }
	public void setWidth(int width)       { this.width = width; }
	public void setHeight(int height)     { this.height = height; }
	public void setHit(boolean hit)       { this.hit = hit; }
	public void setColor(Color color)     { this.color = color; }
	public void setShape(Shape shape)     { this.shape = shape; }
}
