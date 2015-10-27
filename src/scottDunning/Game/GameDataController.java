/*This is a Singleton class used to enable information 
 * flow between the different classes and BasicGameStates
 * with in this program. 
 * */
package scottDunning.Game;

import org.newdawn.slick.Color;

public class GameDataController {
	
	private static GameDataController instance = null;
	
	private GameDataController() {}
	
	public synchronized static GameDataController getInstance() {
		if(instance == null) instance = new GameDataController();
		return instance;
	}
	
	@Override
	public Object clone () throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	private int wave = 0;
	private int score = 0;
	private int timeElapsed = 0;
	private int enemiesKilled = 0;
	private String currentShip = "";
	private Player player = null;
	private Color laserColor = Color.green;
	
	public int getWave()           { return wave; }
	public int getScore()          { return score; }
	public int getTimeElapsed()    { return timeElapsed; }
	public int getEmemiesKilled()  { return enemiesKilled; }
	public String getCurrentShip() { return currentShip; }
	public Player getPlayer()      { return player; }
	public Color getLaserColor()   { return laserColor; }
	
	public void setWave(int wave)               { this.wave = wave; }
	public void setScore(int score)             { this.score = score; }
	public void setTimeElapsed(int time)        { timeElapsed = time; }
	public void setEnemeisKilled(int kills)     { enemiesKilled = kills; }
	public void setCurrentShip(String shipPath) { currentShip = shipPath; }
	public void setPlayer(Player player)        { this.player = player; }
	public void setLaserColor(Color color)      { laserColor = color; }
	
	public int incrementWave()        { wave++; return wave; }
	public int addScore(int addition) { score += addition; return score; }
	public int addKills(int addition) { enemiesKilled += addition; return enemiesKilled; }
	public int incrementKills()       { enemiesKilled++; return enemiesKilled; }
}
