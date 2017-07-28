package barrenmoore;

import java.util.Scanner;

public class Client {

	/**
	 * Variable definitions
	 */
	private GameBoard gameBoard;
	private Player gamePlayer;
	private Scanner inputReader;
	private String lastInput;
	private int currentStep = 0;
	
	/**
	 * Entry point for the game itself
	 * Initialises and starts the game
	 */
	public void runGame() {
		
		DataStorage.toggleDebug(true);
		
		this.gameBoard = new GameBoard(50);
		this.gamePlayer = new Player(this.gameBoard.getBoard().size() / 2, this.gameBoard.getBoard().size() / 2);
		this.inputReader = new Scanner(System.in);
		this.lastInput = "";
		
		this.gameBoard.printBoard();
		
		System.out.printf("[Step %d]: You awaken to find yourself in a barren moor. Try \"look\".\n", this.currentStep);

		while(true) {
			System.out.print(">> ");
			lastInput = inputReader.nextLine().toLowerCase();
			char firstChar = lastInput.charAt(0);
			
			switch(firstChar) {
			case 'l': 
				System.out.printf("[Step %d]: Grey foggy clouds float oppressively close to you,\n", this.currentStep);
				System.out.printf("[Step %d]: reflected in the murky grey water which reaches up your shins.\n", this.currentStep);
				System.out.printf("[Step %d]: Some black plants barely poke out of the shallow water.\n", this.currentStep);
				System.out.printf("[Step %d]: You notice a small watch-like device in your left hand.\n", this.currentStep);
				System.out.printf("[Step %d]: It has hands like a watch, but the hands don't seem to tell time.\n", this.currentStep);
				System.out.printf("[Step %d]: Try \"north\", \"south\", \"east\", or \"west\"\n", this.currentStep);
				break;
			}
			
		}
	}
	
}
