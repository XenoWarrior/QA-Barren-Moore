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
	
	private int currentStep = 1;
	
	/**
	 * Entry point for the game itself
	 * Initialises and starts the game
	 */
	public void runGame() {
		
		//DataStorage.toggleDebug(true);
		
		this.gameBoard = new GameBoard(10);
		this.gamePlayer = new Player(this.gameBoard.getBoard().size() / 2, this.gameBoard.getBoard().size() / 2);
		this.inputReader = new Scanner(System.in);
		this.lastInput = "";
		
		try {
			BoardCell c = this.gameBoard.getCell(this.gamePlayer.getX(), this.gamePlayer.getY());
			c.setItem(CellItem.ITEM_PLAYER);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		this.gameBoard.printBoard();
		
		System.out.printf("[Step %d]: You awaken to find yourself in a barren moor. Try \"look\".\n", this.currentStep);

		while(true) {
			System.out.print(">> ");
			
			this.lastInput = this.inputReader.nextLine().toLowerCase();
			char firstChar = this.lastInput.charAt(0);
			
			switch(firstChar) {
			case 'l': 
				System.out.printf("[Step %d]: Grey foggy clouds float oppressively close to you,\n", this.currentStep);
				System.out.printf("[Step %d]: reflected in the murky grey water which reaches up your shins.\n", this.currentStep);
				System.out.printf("[Step %d]: Some black plants barely poke out of the shallow water.\n", this.currentStep);
				System.out.printf("[Step %d]: You notice a small watch-like device in your left hand.\n", this.currentStep);
				System.out.printf("[Step %d]: It has hands like a watch, but the hands don't seem to tell time.\n", this.currentStep);
				System.out.printf("[Step %d]: Try \"north\", \"south\", \"east\", or \"west\".\n", this.currentStep);
				System.out.printf("[Step %d]: When you move, try \"read\".\n", this.currentStep);
				this.currentStep++;
				break;
			case 'r':
				System.out.printf("[Step %d]: The watch-like device reads %d m.\n", this.currentStep, 0);
				break;
			case 'n':
				System.out.printf("[Step %d]: You move north.\n", this.currentStep);
				this.gamePlayer.move(MoveDirection.DIRECTION_NORTH);
				this.currentStep++;
				break;
			case 'e':
				System.out.printf("[Step %d]: You move east.\n", this.currentStep);
				this.gamePlayer.move(MoveDirection.DIRECTION_EAST);
				this.currentStep++;
				break;
			case 's':
				System.out.printf("[Step %d]: You move south.\n", this.currentStep);
				this.gamePlayer.move(MoveDirection.DIRECTION_SOUTH);
				this.currentStep++;
				break;
			case 'w':
				System.out.printf("[Step %d]: You move west.\n", this.currentStep);
				this.gamePlayer.move(MoveDirection.DIRECTION_WEST);
				this.currentStep++;
				break;
			default:
				System.out.printf("[Step %d]: You sit in the swamp, unable to decide what to do. (command not found [%s])\n", this.currentStep, this.lastInput);
				break;
			}
			
		}
	}
	
}
