package tetris;

import org.newdawn.slick.Color;

public class JPiece extends Piece {
	private Block [][] layout;
	private Color color; 
	
	public JPiece(int x, int y) {
		super(x,y);
		color = new Color(Color.green);
		layout = super.getLayout();
		
		//makes the 2D array shaped like a J
		layout[0][0] = new Block(color);
		layout[1][0] = new Block(color);
		layout[0][1] = new Block(color);
		layout[0][2] = new Block(color);
		
		super.setHeight(60);
		super.setWidth(40);
	}
	public void rotate(){
		super.rotate();
		switch(super.getRotateCounter()){
		case 1:
			super.setHeight(60);
			super.setWidth(40);
			break;
		case 2:
			super.setHeight(40);
			super.setWidth(80);
			super.setLeftBarrier(0);
			break;
		case 3:
			super.setHeight(80);
			super.setWidth(80);
			super.setLeftBarrier(-20);
			break;
		case 4:
			super.setHeight(80);
			super.setWidth(60);
			super.setLeftBarrier(20);
			break;
		}
	}

}
