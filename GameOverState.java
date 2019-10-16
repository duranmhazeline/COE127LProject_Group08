package tetris;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

public class GameOverState extends BasicGameState{
	private Updater u;
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		u = new Updater();
	}

	public void render(GameContainer container, StateBasedGame arg1, Graphics g) throws SlickException {
		//creates graphics for game over screen
		g.setColor(Color.white);
		g.drawString("Game Over", 150, 100);
		g.drawString("Points Earned: "+ u.getScore(), 100, 150);
	}

	public void update(GameContainer container, StateBasedGame sbg, int arg2) throws SlickException {
		
	}

	public int getID() {
		return 1;
	}

}
