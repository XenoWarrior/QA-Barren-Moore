package barrenmoore;

public class Client {

	/**
	 * Variable definitions
	 */
	private GameBoard gameBoard;
	
	/**
	 * Entry point for the game itself
	 * Initialises and starts the game
	 */
	
	public void runGame() {
		
		this.gameBoard = new GameBoard(50);
		
	}
	
}
