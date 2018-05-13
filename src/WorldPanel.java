import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import org.omg.Messaging.SyncScopeHelper;

public class WorldPanel extends JPanel implements MouseListener, ActionListener {
	private int cellsPerRow;
	private int cellSize;
	private Cell[][] cells;
	private Timer timer;
	
	public WorldPanel(int w, int h, int cpr) {
		setPreferredSize(new Dimension(w, h));
		addMouseListener(this);
		timer = new Timer(500, this);
		this.cellsPerRow = cpr;
	
		//calculate the cellSize
		cellSize = w/cpr;
		
		//initialize the cells array
		cells = new Cell[w][h];
		
		//initialize each cell in the array
		for (int j = 0; j < cells.length; j++) {
		for (int i = 0; i < cells.length; i++) {
			cells[i][j] = new Cell(i,j,cellSize);
			System.out.println("CellMade " + i + ", " + j);
		}
		}
	}
	
	public void randomizeCells() {
		// make each cell alive or dead randomly
		for (int j = 0; j < cells.length; j++) {
			for (int i = 0; i < cells.length; i++) {
				Random rand = new Random();
				if(rand.nextInt(2) == 1){
					cells[i][j].isAlive = true;
					cells[i][j].draw(getGraphics());
					
				} else {
					cells[i][j].isAlive = false;
				}

				
			}
			}
		
	}
	
	public void clearCells() {
		// set isAlive to false for all cells
		for (int j = 0; j < cells.length; j++) {
			for (int i = 0; i < cells.length; i++) {


					cells[i][j].isAlive = false;


				
			}
			}
		repaint();
	}
	
	public void startAnimation() {
		timer.start();
	}
	
	public void stopAnimation() {
		timer.stop();
	}
	
	public void setAnimationDelay(int sp) {
		timer.setDelay(sp);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//iterate through the cells and draw them
	}
	
	//advances world one step
	public void step() {
		//initialize the numLivingNbors variable to be the same size as the cells
		int[][] numLivingNbors;
		
		//iterate through the cells and populate the numLivingNbors array with their neighbors
		
		
		repaint();
	}
	
	//returns an array list of the  8 or less neighbors of the 
	//cell identified by x and y
	public int getLivingNeighbors(int x, int y){
		int livingNeighbors = 0;
		
		//add 1 to livingNeighbors for each
		//neighboring cell that is alive
		
		return livingNeighbors;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// IGNORE
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// IGNORE
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// IGNORE
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//get the location of the mouse
		
		//toggle the cell at that location to either alive or dead
		//based on its current state
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// IGNORE
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		step();		
	}
}
