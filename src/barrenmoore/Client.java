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
		
		DataStorage.toggleDebug(true);
		
		this.gameBoard = new GameBoard(10);
		this.gamePlayer = new Player(this.gameBoard.getBoard().size() / 2, this.gameBoard.getBoard().size() / 2);
		this.inputReader = new Scanner(System.in);
		this.lastInput = "";
		
		this.gameBoard.getCell(this.gamePlayer.getX(), this.gamePlayer.getY()).setItem(CellItem.ITEM_PLY);
		this.gameBoard.printBoard();
		
		System.out.printf("[Step %d]: You awaken to find yourself in a barren moor. Try \"look\".\n", this.currentStep);

		while(true) {
			
			if(this.gameBoard.distanceFrom(CellItem.ITEM_TRE, this.gamePlayer.getX(), this.gamePlayer.getY()) == 0) {
				System.out.println("Game Over! You found the treasure after " + this.currentStep + " steps!");
			}
			
			System.out.print(">> ");
			
			this.lastInput = this.inputReader.nextLine().toLowerCase();

			if(this.lastInput.length() > 0) {
				char firstChar = this.lastInput.charAt(0);
				
				if(firstChar == 'n' || firstChar == 'e' || firstChar == 's' || firstChar == 'w') {
					this.gameBoard.getCell(this.gamePlayer.getX(), this.gamePlayer.getY()).setItem(CellItem.ITEM_NON);
				}
				
				switch(firstChar) {
				
				case 'l': 
					System.out.printf("[Step %d]: Grey foggy clouds float oppressively close to you,\n", this.currentStep);
					System.out.printf("[Step %d]: reflected in the murky grey water which reaches up your shins.\n", this.currentStep);
					System.out.printf("[Step %d]: Some black plants barely poke out of the shallow water.\n", this.currentStep);
					System.out.printf("[Step %d]: You notice a small watch-like device in your left hand.\n", this.currentStep);
					System.out.printf("[Step %d]: It has hands like a watch, but the hands don't seem to tell time.\n", this.currentStep);
					System.out.printf("[Step %d]: Try \"north\", \"south\", \"east\", or \"west\".\n", this.currentStep);
					System.out.printf("[Step %d]: When you move, try \"read\".\n", this.currentStep);
					System.out.printf("[Step %d]: You can give up by using \"quit\".\n", this.currentStep);
					break;
					
				case 'r':
					System.out.printf("[Step %d]: The watch-like device reads %f m.\n", this.currentStep, this.gameBoard.distanceFrom(CellItem.ITEM_TRE, this.gamePlayer.getX(), this.gamePlayer.getY()));
					break;
					
				case 'n':
					System.out.printf("[Step %d]: You moved north.\n", this.currentStep);	
					this.gamePlayer.move(MoveDirection.DIRECTION_NORTH);
					this.currentStep++;
					break;
					
				case 'e':
					System.out.printf("[Step %d]: You moved east.\n", this.currentStep);
					this.gamePlayer.move(MoveDirection.DIRECTION_EAST);
					this.currentStep++;
					break;
					
				case 's':
					System.out.printf("[Step %d]: You moved south.\n", this.currentStep);
					this.gamePlayer.move(MoveDirection.DIRECTION_SOUTH);
					this.currentStep++;
					break;
					
				case 'w':
					System.out.printf("[Step %d]: You moved west.\n", this.currentStep);
					this.gamePlayer.move(MoveDirection.DIRECTION_WEST);
					this.currentStep++;
					break;
				
				case 'q':
					System.out.printf("[Step %d]: You decide to give up, the monsters in the world move to devour you.\n", this.currentStep);
					System.out.printf("[Step %d]: It won't be long before you become food.\n", this.currentStep);
					System.exit(0);
					break;
					
					
				default:
					System.out.printf("[Step %d]: You sit in the swamp, unable to decide what to do. (command not found [%s])\n", this.currentStep, this.lastInput);
					break;
				}
	
				if(firstChar == 'n' || firstChar == 'e' || firstChar == 's' || firstChar == 'w') {
					this.gameBoard.getCell(this.gamePlayer.getX(), this.gamePlayer.getY()).setItem(CellItem.ITEM_PLY);
				}
				
				this.gameBoard.printBoard();
				System.out.printf("[Step %d]: The watch-like device reads %f m.\n", this.currentStep, this.gameBoard.distanceFrom(CellItem.ITEM_TRE, this.gamePlayer.getX(), this.gamePlayer.getY()));
				
				if(DataStorage.debugEnabled()) {
					System.out.printf("[Step %d]: Player pos [y: %d, x: %d].\n", this.currentStep, this.gamePlayer.getY(), this.gamePlayer.getX());
				}
			}
		}
	}
	
}
