package tetris;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class Updater {

	private Piece currentPiece;
	private Block [][] old;
	private int numTypes = 7;
	private Random rand;
	private int blockSize = 20;
	private int rowDelete;
	private int score;
	private int countScore;
	private boolean gameEnd;

	public Updater() {
		rand = new Random();
		old = new Block[400][600];
		generatePiece();
		setScore(0);
		countScore = 0;
		gameEnd= false;
	}
	//constantly updates the game to make the pieces fall and receives other commands
	public void update(GameContainer container, int delta) {
		Input input = container.getInput();
		
		int yCord = currentPiece.getY();
		int xCord = currentPiece.getX();	
		
		currentPiece.fall(yCord, delta);//makes the piece periodically fall
		//series of if statements that receive key inputs and moves the piece.
		if(input.isKeyPressed(input.KEY_LEFT)){
			currentPiece.moveLeft(xCord);
		}
		if(input.isKeyPressed(input.KEY_RIGHT)){
			currentPiece.moveRight(xCord);
		}
		if(input.isKeyPressed(input.KEY_UP)){
			currentPiece.rotate();
		}
		if(input.isKeyDown(input.KEY_DOWN)){
				currentPiece.fallFast(yCord, delta);	
				countScore=+3;
		}
		//checks to see if the piece can still falls
		if(canNotFall()){
			System.out.println(currentPiece.getX()+","+currentPiece.getY());
			if(currentPiece.getY()<=60){
				gameEnd=true;
			}else{
				addToLayout();
				generatePiece();		
			}
		}
		//removes the row that is filled up
		if(checkRow()==16){
			removeRow();
		}
	}

	// Generates a random piece
	public void generatePiece(){
		int type = rand.nextInt(numTypes)+1;
		int xCoord = 180;
		int yCoord = 50;
	
		switch (type){
		case 1: 
			setCurrentPiece(new SquarePiece(xCoord, yCoord));
			break;
		case 2:
			setCurrentPiece(new IPiece(xCoord,yCoord));
			break;	
		case 3:
			setCurrentPiece(new JPiece(xCoord,yCoord));
			break;
		case 4:
			setCurrentPiece(new TPiece(xCoord,yCoord));
			break;
		case 5:
			setCurrentPiece(new SPiece(xCoord,yCoord));
			break;
		case 6:
			setCurrentPiece(new ZPiece(xCoord,yCoord));
			break;
		case 7:
			setCurrentPiece(new LPiece(xCoord,yCoord));
			break;		
		}
	}
	//checks to see if the piece can fall or not
	public boolean canNotFall(){
		//checks if piece hits the bottom of the screen
		if(currentPiece.getY()>=(500-currentPiece.getHeight())){
			return true;
		}
		//checks if the piece hits another piece
		Block [][] b = currentPiece.getLayout();
		for(int i=0; i<b.length;i++){
			for(int j=0; j<b[i].length;j++){
				if(b[i][j]!=null){
					int xCoord = currentPiece.getX() + (blockSize*i);
					int yCoord = currentPiece.getY() + (blockSize*j);
					if(old[xCoord][yCoord+blockSize] != null){
						return true;
					}
				}	
			}
		}
		return false;
	}
	//adds the fallen piece to a large 2d array that contains the entire screen
	public void addToLayout(){
		Block [][] b = currentPiece.getLayout();
		for(int i=0; i<b.length;i++){
			for(int j=0; j<b[i].length;j++){
				if(b[i][j]!=null){
					int xCoord = currentPiece.getX() + (blockSize*i);
					int yCoord = currentPiece.getY() + (blockSize*j);
					//bug handing where y-Coordinate doesn't become interval of 20
					int round = yCoord%20;
					if(round!=0){
						if(round<=10){
							yCoord-=round;
						}else if(round>10){
							yCoord=yCoord+20-round;
						}
					}
					old [xCoord][yCoord] = b[i][j];
				}	
			}
		}
	}
	//checks if the row is complete
	public int checkRow(){
		int count = 0;
		for(int j=480; j>0; j=j-20){	
			for(int i=40; i<old.length; i=i+20){
				if(old[i][j]!=null){
					count++;
				}else if(count!=16){
					count =0;
				}
			}
			if(count==16){
				rowDelete = j;
				break;
			}
		}
		return count;
	}
	//removes the row if it is complete
	public void removeRow(){
		for(int j=480; j>0; j=j-20){
			for(int i=40; i<old.length; i=i+20){
				if(rowDelete == j){
					old[i][j]= null;
				}
			}
		}
		//makes the blocks on top fall 
		for(int y=rowDelete; y>0;y=y-20){
			for(int x=40; x<old.length; x=x+20){
				Block [][]temp = old;
				old[x][y] = temp[x][y-20];
			}
		}
		//updates the score
		setScore(getScore() + 100);
	}
	
	
//getter and setters
	public Piece getCurrentPiece() {
		return currentPiece;
	}

	public void setCurrentPiece(Piece currentPiece) {
		this.currentPiece = currentPiece;
	}

	public Block [][] getOld() {
		return old;
	}

	public void setOld(Block [][] old) {
		this.old = old;
	}

	public int getRowDelete() {
		return rowDelete;
	}

	public void setRowDelete(int rowDelete) {
		this.rowDelete = rowDelete;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isGameEnd() {
		return gameEnd;
	}

	public void setGameEnd(boolean gameEnd) {
		this.gameEnd = gameEnd;
	}

}
