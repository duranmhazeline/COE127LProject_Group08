package tetris;

import org.newdawn.slick.Color;

public class IPiece extends Piece {
	private Block [][] layout;
	private Color color; 
	
	public IPiece(int x, int y) {
		super(x,y);
		color = new Color(Color.cyan);
		layout = super.getLayout();
		layout[0][0] = new Block(color);
		layout[0][1] = new Block(color);
		layout[0][2] = new Block(color);
		layout[0][3] = new Block(color);
		
		super.setHeight(80);
		super.setWidth(20);
	}
	
	public void rotate(){
		super.rotate();
		System.out.println(super.getRotateCounter());
		switch(super.getRotateCounter()){
		case 1:
			super.setHeight(80);
			super.setWidth(20);
			break;
		case 2:
			super.setHeight(20);
			super.setWidth(80);
			break;
		case 3:
			super.setHeight(80);
			super.setWidth(80);
			super.setLeftBarrier(-40);
			break;
		case 4:
			super.setHeight(80);
			super.setWidth(80);
			break;
		}
	}
}
