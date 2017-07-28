package barrenmoore;

public class Client {

	/**
	 * Variable definitions
	 */
	private GameBoard gameBoard;
	private Player gamePlayer;
	
	/**
	 * Entry point for the game itself
	 * Initialises and starts the game
	 */
	public void runGame() {
		
		this.gameBoard = new GameBoard(50);
		this.gameBoard.printBoard();
		
		this.gamePlayer = new Player(this.gameBoard.getBoard().size() / 2, this.gameBoard.getBoard().size() / 2);

	}
	
}
