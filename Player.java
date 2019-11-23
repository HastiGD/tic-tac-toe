package lab3;
import java.util.*;

/*
 * The Player class could be used to contain all the data for each player,
 * it could be used to make a move, and it could keep track of that players
 * occupied spaces. It could also keep track of wins in case the player wants 
 * play multiple rounds. The TicTacToe class would then only be responsible
 * for displaying the board, switching between players, validating moves,
 * and detecting wins or a stalemate.
 */

public class Player {
	char symbolType;
	ArrayList <String> occupiedSpaces;
	
	public Player(char symbol) {
		symbolType = symbol;
	}
	
	public char getSymbol() {
		return this.symbolType;
	}
	
	public boolean play(String position) {
		// if position represents a valid move (e.g., A1, B3)
		
			// add the current player's symbol to the board and return true
		// otherwise 
			// return false
		
		boolean validMove = true;
		
		return validMove;
	}

	public static void main(String[] args) {

	}
}
