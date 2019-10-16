package tetris;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.*;

//game state that makes the game playable
public class PlayState extends BasicGameState{
	private Renderer r;
	private Updater u;
	
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		r = new Renderer();
		u = new Updater();
	}

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		u.update(container, delta);
	}
	public void render(GameContainer arg0, StateBasedGame sbg, Graphics g) throws SlickException {
		r.render(u, g);
		//check if game over
		if(u.isGameEnd()){
			System.out.println("asdfasfd");
			if(u.getCurrentPiece().getY() <= 100){
				sbg.enterState(1);
			}
		}
	}

	public int getID() {
		return 0;
	}

}

