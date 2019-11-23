package lab3;
import java.awt.*;
import javax.swing.*;
/*
 * The GameBoard class is a GUI representation of the TicTacToe game, 
 * running this source code will generate a TicTacToe grid on a blank canvas in a separate window
 * the window can be moved or partially obscured by other windows on the users screen
 * and the grid will still remain intact. I would like to learn more about GUI's and 
 * Java's Swing Library in order to create a TicTacToe GUI. 
 */

public class GameBoard extends Canvas {
	private static final int WINDOW_DIMENSION = 600;
	private static final String NAME_OF_GAME = "Tic Tac Toe";
	
	public void displayGameBoard() {
		// create a frame object to house the GameBoard object
		JFrame frame = new JFrame(NAME_OF_GAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// create a GameBoard object  to display
		Canvas canvas = new GameBoard();
		canvas.setSize(WINDOW_DIMENSION, WINDOW_DIMENSION);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
	}
	
	@Override 
	public void paint(Graphics g) {	
		// draw and display the board
		super.paint(g);
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(3));
	    // draw vertical lines
		g2.drawLine(225, 100, 225, 500); 
		g2.drawLine(375, 100, 375, 500);
		// draw horizontal lines
		g2.drawLine(100, 225, 500, 225); 
		g2.drawLine(100, 375, 500, 375);
	}
	
	public static void main(String[] args) {
		GameBoard myGB = new GameBoard();
		myGB.displayGameBoard();
		
	}

}
