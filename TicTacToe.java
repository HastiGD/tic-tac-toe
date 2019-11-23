package lab3;

import java.util.*;

public class TicTacToe {
	// the board is initialized and its dimensions are specified
	private char[][] board;
	private static final int BOARD_DIMS = 3;
	// create scanner object
	Scanner in = new Scanner(System.in);
	// initialize player
	private char player = 'X';
	// position to be validated for next move
	int row = -1;
	int col = -1;
	
	public TicTacToe() {
		// constructor generates an empty board
		this.board =  new char[BOARD_DIMS][BOARD_DIMS];
		// the column labels are printed first
		printColumnHeader();
		// each row is iterated through
		for (int r = 0; r < BOARD_DIMS; r++) {
			// the row labels are printed
			System.out.print((r+1) + "  ");
			// each element in that row is iterated through
			for (int c = 0; c < BOARD_DIMS; c++) {
				System.out.print(preChar);
				// each element in that row is initialized with the space char
				this.board[r][c] = ' ';
				// each element in that row is then printed
				System.out.print(this.board[r][c]);
				System.out.print(postChar);
			}
			System.out.println();
			System.out.println();
		}
	}
		
	public boolean play() {
		// initialize validMove
		boolean validMove = false;
		// ask for players move
		formatPosition();
		// validate players next move
		if (this.board[this.row][this.col] == ' ') {
			// place current players symbol
			this.board[this.row][this.col] = this.player;
			validMove = true;
			printBoard();
		}
			else {
				validMove = false;
				System.out.println("\nNot a Valid Move");
		}
		return validMove;
	}
	
	public void printBoard() {
		// prints the current board
		// print the column labels first
		printColumnHeader();
		// each row is iterated through
		for (int r = 0; r < this.board.length; r++) {
			// print the row label
			System.out.print((r+1) + "  ");
			// each element in the row is iterated through
			for (int c = 0; c < this.board.length; c++) {
				// print each element in that row 
				System.out.print(preChar);
				System.out.print(this.board[r][c]);
				System.out.print(postChar);
			}
			System.out.println();
			System.out.println();
		}
	}
	
	public boolean won() {
		boolean isWinner = false;
		
		// check column for win
        for (int i = 0; i < this.board.length; i++) {
            if (this.board[this.row][i] != this.player) {
                break;
            }
            if (i == this.board.length-1) {
                // report win for player
            	System.out.println("Player " + this.player + " is the Winner!");
            	isWinner = true;
            }
        }
        
        // check row for win
        for (int i = 0; i < this.board.length; i++) {
            if (this.board[i][this.col] != this.player) {
                break;
            }
            if (i == this.board.length-1) {
                // report win for player
            	System.out.println("Player " + this.player + " is the Winner!");
            	isWinner = true;
            }
        }
        
	    // check if on diagonal
	    if (this.row == this.col) {
            // we're on a diagonal
            for (int i = 0; i < this.board.length; i++) {
                if (this.board[i][i] != this.player) {
                    break;
                }
                if(i == this.board.length-1) {
                    // report win for player
                	System.out.println("Player " + this.player + " is the Winner!");
                	isWinner = true;
                }
            }
	    }
	    
	    // check if on other diagonal
	    if (this.row == ((this.board.length -1) - this.col)) {
	    	// we're on other diagonal
	    	for (int i = 0; i < this.board.length; i++) {
	    		if (this.board[(this.board.length-1)-i][i] != this.player) {
	    			break;
	    		}
	    		if (i == this.board.length - 1) {
	    			// report win for player
	    			System.out.println("Player " + this.player + " is the Winner!");
                	isWinner = true;
	    		}
	    	}
	    }
	    return isWinner;
	}
	
	public boolean stalemate() {
		// returns true if there are no places left to move
		boolean noMoreMoves = false;
		int totalSpaces = 9;
		// iterate through each element in the board
		for (int r = 0; r < this.board.length; r++) {
			for (int c = 0; c < this.board.length; c++) {
				// look for an empty space
				if (this.board[r][c] != ' ') {
					totalSpaces --;
				}
				if (totalSpaces == 0) {
					// announce stalemate
					System.out.println("Stalemate!");
					noMoreMoves = true;
				}
			}
		}
		return noMoreMoves;
	}
	
	private void switchTurn() {
		// switches between players X and O
		switch(this.player) {
		case 'X':
			this.player = 'O';
			break;
		case 'O':
			this.player = 'X';
			break;
		}
	}
	
	private void formatPosition() {
		boolean validPosition = false;
		
		while (validPosition == false) {
			// prompts user for next move
			System.out.println("\nPlayer " + this.player + " Enter the Coordinates of Your Next Move: Column, Row");
			String position = in.nextLine();
			// remove spaces and special characters
			position = position.replaceAll("[^a-zA-Z0-9]", "");
			// extract row and column values
			char colChar = position.charAt(0);
			char rowChar = position.charAt(1);
			// convert row to int
			int row = Character.getNumericValue(rowChar);
			// convert row and column values to array indices, and assign new position
			if ((colChar == 'a' || colChar == 'A') && (row > 0 && row <= this.board.length)) {
				// convert to int 0
				this.col = 0;
				this.row = (row-1);
				validPosition = true;
			}
			else if ((colChar == 'b' || colChar == 'B') && (row > 0 && row <= this.board.length)) {
				// convert to int 1
				this.col = 1;
				this.row = (row-1);
				validPosition = true;
			}
			else if ((colChar == 'c' || colChar == 'C') && (row > 0 && row <= this.board.length)) {
				// convert to int 2
				this.col = 2;
				this.row = (row-1);
				validPosition = true;
			}
			else {
				validPosition = false;
				// ask for valid input
				System.out.println("\nPlease Enter a Valid Move");
			}
		}
	}
	
	// some formatting variables for the board
	private String preChar = "[ ";
	private String postChar = " ] ";
	private String colLabel = "     A     B     C   ";
	
	private void printColumnHeader() {
		// prints the column labels
		System.out.println();
		System.out.println(colLabel);
		System.out.println();
	}
	
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		while (!game.stalemate()) {
			while (game.play()) {
				if (game.won()) {
					break;
				}
				else {
					game.switchTurn();
				}
			}
			if (game.won()); {
				break;
			}
		}
	}
}
