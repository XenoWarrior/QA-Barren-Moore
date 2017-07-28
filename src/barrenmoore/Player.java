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
		this.playerX = px;
		this.playerY = py;
	}

	public void setX(int px) {
		this.playerX = px;
	}

	public void setY(int py) {
		this.playerY = py;
	}
	
}
