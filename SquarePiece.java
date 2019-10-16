package tetris;

import org.newdawn.slick.Color;

public class SquarePiece extends Piece{	
	private Block [][] layout;
	private Color color; 
	
	public SquarePiece(int x, int y) {
		super(x,y);
		color = new Color(Color.yellow);
		layout = super.getLayout();
		layout[0][0] = new Block(color);
		layout[0][1] = new Block(color);
		layout[1][0] = new Block(color);
		layout[1][1] = new Block(color);
		
		super.setHeight(40);
		super.setWidth(40);
	}
	public void rotate(){
		
	}
}
