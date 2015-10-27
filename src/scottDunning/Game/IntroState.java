package scottDunning.Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class IntroState extends BasicGameState {
	
	long runningTime = 0;
	private Image logo = null;
	private Image background = null;
	private String next = "Press Space to Continue...";

	@Override
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		logo = new Image("images/logo.png");
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		runningTime += delta;
		if(runningTime > 10000 || container.getInput().isKeyPressed(Input.KEY_SPACE)) 
			sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		logo.draw((container.getWidth()/2) - (logo.getWidth()/2), (container.getHeight()/2) - (logo.getHeight()/2));
		g.setColor(Color.green);
		g.drawString(next, 
				(container.getWidth()/2) - 130, (container.getHeight()/2) + (logo.getHeight()));
	}

	@Override
	public int getID() { return 0; }

}
