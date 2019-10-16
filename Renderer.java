package tetris;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.*;

public class Renderer {
	private int blockSize = 20;
	
	public void render(Updater updater, Graphics g){
		
		//renders background
		for(int p =0; p <20; p++){
			for(int q =0; q<25; q++){
				Rectangle rect = new Rectangle(blockSize*p,blockSize*q,blockSize,blockSize);
				g.setColor(Color.darkGray);
				g.draw(rect);
			}
		}
		g.setColor(Color.lightGray);
		g.fill(new Rectangle(0,0,40,500));
		g.fill(new Rectangle(0,0,120,100));
		g.fill(new Rectangle(360,0,40,500));
		g.fill(new Rectangle(280,0,120,100));

		//displays current score
		g.setColor(Color.white);
		g.drawString("Score: "+updater.getScore(), 0, 40);
		
		//renders the piece that is falling
		Piece piece = updater.getCurrentPiece();
		Block [][] p = piece.getLayout();
		for(int i=0; i<p.length; i++){
			for(int j=0;j<p[i].length;j++){
				if(p[i][j]!= null){
					int xCoord = piece.getX() + (blockSize*i);
					int yCoord = piece.getY() + (blockSize*j);
					Rectangle rect = new Rectangle(xCoord,yCoord,blockSize,blockSize);
					g.setColor(Color.darkGray);
					g.draw(rect);
					g.setColor(p[i][j].getColor());
					g.fill(rect);
				}
			}
		}
		
		//renders old pieces that have fallen
		Block [][] layout = updater.getOld();
		for(int x=0; x<layout.length; x++){
			for(int y=0; y<layout[x].length;y++){
				if(layout[x][y] !=null){
					Rectangle rect = new Rectangle(x,y, blockSize, blockSize);
					g.setColor(Color.darkGray);
					g.draw(rect);
					g.setColor(layout[x][y].getColor());
					g.fill(rect);
				}
			}
		}
	}
}
