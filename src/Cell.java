import java.awt.Color;
import java.awt.Graphics;

public class Cell implements Drawable{
	public boolean isAlive = false;
	
	private int x;
	private int y;

	private int cellSize;
	
	
	public Cell(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.cellSize = size;
	}
	
	//sets isAlive to true or false based on the neighbors and 
	//the rules of the game
	/*
	 * 1. Any live cell with fewer than two live nieghbours dies, as if caused by underpopulation.
	 * 2. Any live cell with two or three live neighbours lives on to the next generation.
	 * 3. Any live cell with more than three live neighbours dies, as if by overpopulation.
	 * 4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
	 * (source: Wikipedia)
	 * */
	public void liveOrDie(int numNeighbors) {
		if (numNeighbors < 2) {
			isAlive = false;
		}
		if (numNeighbors == 3) {
			isAlive = true;
		}
		if (numNeighbors > 3) {
			isAlive = false;
		}
		
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	//draws colored square if cell is alive
	//draws empty square if cell is dead
	@Override
	public void draw(Graphics g) {
		if (isAlive == true) {
			g.setColor(Color.RED);
			g.fillRect(x, y, cellSize, cellSize);
		} else {
			//238 for natural (invisible) background
			g.setColor(new Color(250,250,250));
			g.fillRect(x, y, cellSize, cellSize);
		}
	}
}
