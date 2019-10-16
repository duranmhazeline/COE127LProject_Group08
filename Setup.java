package tetris;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Setup extends StateBasedGame{

	//public static int gameScore = 0;
	//public static int lives = 3;
	public Setup(String title) {
		super(title);
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Setup("setup test"));
		app.setDisplayMode(400, 500, false);
		app.setAlwaysRender(true);
		app.setTargetFrameRate(60);
		app.start();
	}

	public void initStatesList(GameContainer container) throws SlickException {
		this.addState(new PlayState());
		this.addState(new GameOverState());
		
	}

	

}
