import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 *  1. Check out the Wikipedia page on Conway's Game of Life to familiarize yourself
 *     with the concept.
 *     
 *	https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 */

/*
 *  2. Run the ConwaysGOL.jar to see a demo of the final product.
 */

/* 
 *  3. Create the program on your own or fill in the code under the comments to complete the project.
 *
 */

public class ConwaysGameOfLife extends JPanel implements ActionListener{
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final int CELLS_PER_ROW = 500;
	
	public boolean isRunning = false;
	
	private JFrame window;
	private JPanel inputPanel;
	private JButton startStopButton;
	private JButton randomizeButton;
	private JButton clearButton;
	private JLabel speedLabel;
	private JTextField speedField;
	
	private WorldPanel gamePanel;
	
	public static void main(String[] args) {
		new ConwaysGameOfLife().launchGame();
	}
	
	public void launchGame() {
		window = new JFrame();
		inputPanel = new JPanel();
		gamePanel = new WorldPanel(WIDTH,HEIGHT,CELLS_PER_ROW);
		startStopButton = new JButton();
		startStopButton.setText("Start");
		startStopButton.addActionListener(this);
		randomizeButton = new JButton();
		randomizeButton.setText("Randomize");
		randomizeButton.addActionListener(this);
		clearButton = new JButton();
		clearButton.setText("Clear");
		clearButton.addActionListener(this);
		speedLabel = new JLabel();
		speedLabel.setText("Speed");
		speedField = new JTextField();
		//build the window and start the simulation
		window.add(inputPanel);
		inputPanel.add(startStopButton);
		inputPanel.add(speedLabel);
		inputPanel.add(randomizeButton);
		inputPanel.add(clearButton);
		inputPanel.add(gamePanel);
		window.setVisible(true);
		window.setBounds(200, 200, 800, 800);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//if startStopButton is pressed, 
			// toggle isRunning to the opposite of its current state
			// start or stop the animation based on the state of isRunning
		if(e.getSource() == startStopButton) {
			if(isRunning == false) {
				isRunning = true;
				startStopButton.setText("Stop");
				gamePanel.startAnimation();
			} else if(isRunning == true) {
				isRunning = false;
				startStopButton.setText("Start");
				gamePanel.stopAnimation();
			}
		}
		// if ranomizeButton is pressed
			// call randomizeCells
		if(e.getSource() == randomizeButton) {
			gamePanel.randomizeCells();
			System.out.println("Pressed");
			window.setBounds(200, 200, 800, 800);
			
		}
		// if clearButton is pressed
			//call clearCells
		if(e.getSource() == clearButton) {
			gamePanel.clearCells();
		}
	}
	}

