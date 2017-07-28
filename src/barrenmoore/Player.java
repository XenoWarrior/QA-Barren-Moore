package barrenmoore;

public class Player {

	/**
	 * Variable definitions
	 */
	private int playerX = 0;
	private int playerY = 0;
	
	/**
	 * Constructs a new player
	 * @param px, the player X pos
	 * @param py, the player Y pos
	 */
	public Player(int px, int py) {
		
		if(DataStorage.debugEnabled()) {
			System.out.printf("[Player]: Made new player at position [%d, %d]\n", px, py);
		}
		
		this.playerX = px;
		this.playerY = py;
	}

	/**
	 * Sets the X position for the player
	 * @param px, the position to move the player to on X
	 */
	public void setX(int px) {
		this.playerX = px;
	}

	/**
	 * Sets the Y position for the player
	 * @param py, the position for move the player to on Y 
	 */
	public void setY(int py) {
		this.playerY = py;
	}
	
	
	
}
