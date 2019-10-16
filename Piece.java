package tetris;

public class Piece {
	private int x;
	private int y;
	private int blockSize;
	private Block [][] layout;
	private int height;
	private int width;
	private int rotateCounter;
	private int leftBarrier;

	public Piece (int x, int y){
		this.setX(x);
		this.setY(y);
		blockSize = 20;
		setLayout(new Block[4][4]);//creates a 2d array to make each unique block
		rotateCounter = 1;
		setLeftBarrier(20);
	}
	
	//makes piece fall
	public void fall(int y, int delta){
		y = y +delta/10;
		int round = getY()%20;
		if(round!=0){
			setY(y-round);
		}
		setY(y);
	}
	//makes piece fall fast
	public void fallFast(int yCord, int delta){
		yCord += delta/5;
		setY(yCord);
	}
	
	//moves piece to the left
	public void moveLeft(int xCord){
		xCord -= 20;
		if(xCord<=leftBarrier){ 
			return; //removes bug that block crosses barrier
		}
		setX(xCord);
	}
	//moves piece to the right
	public void moveRight(int xCord){
		xCord += 20;
		if(xCord>=380-getWidth()){
			return; //removes bug that block crosses barrier
		}
		setX(xCord);
	}
	//rotates the piece 
	public void rotate(){
		rotateCounter++;
		if(rotateCounter==5){
			rotateCounter=1;
		}
		Block [][] temp = new Block[4][4];
		for(int i=0; i<layout.length; i++){
			for(int j=0; j<layout.length; j++){
				temp [i][j] = layout [j][temp.length-1-i];
			}
		}
		setLayout(temp);
	}
	// getters and setters 
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public Block [][] getLayout() {
		return layout;
	}

	public void setLayout(Block [][] layout) {
		this.layout = layout;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getRotateCounter() {
		return rotateCounter;
	}

	public void setRotateCounter(int rotateCounter) {
		this.rotateCounter = rotateCounter;
	}

	public int getLeftBarrier() {
		return leftBarrier;
	}

	public void setLeftBarrier(int leftBarrier) {
		this.leftBarrier = leftBarrier;
	}

}
