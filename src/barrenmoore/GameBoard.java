package barrenmoore;

import java.util.HashMap;
import java.util.Random;

public class GameBoard {

	/**
	 * Variable definitions
	 */
	private HashMap<Integer, HashMap<Integer, BoardCell>> boardGrid = new HashMap<Integer, HashMap<Integer, BoardCell>>();
	private HashMap<Integer, HashMap<Integer, BoardCell>> cachedObjects = new HashMap<Integer, HashMap<Integer, BoardCell>>();

	private int boardStartX = 0;
	private int boardStartY = 0;
	private int boardEndX = 0;
	private int boardEndY = 0;
	
	/**
	 * Constructs a new game board
	 * @param size
	 */
	public GameBoard(int size) {
		// Generate a new board
		for(int i = boardStartY; i < size; i++) {
			HashMap<Integer, BoardCell> boardRow = new HashMap<Integer, BoardCell>();
			for(int j = boardStartX; j < size; j++) {
				
				/*Random r = new Random();
				int rn = r.nextInt(100);
				
				if(rn < 100 && rn > DataStorage.getTreasureChance()) {
					if(DataStorage.debugEnabled()) {
						System.out.printf("[GameBoard]: Generated cell [%d, %d] with [%s].\n", j, i, CellItem.ITEM_TREASURE);						
					}
				}*/
				
				boardRow.put(j, new BoardCell(CellItem.ITEM_NON, j, i));
			}
			boardGrid.put(i, boardRow);
		}

		this.boardEndX = size-1;
		this.boardEndY = size-1;
		
		this.boardStartX = 0;
		this.boardStartY = 0;
	}
	
	/**
	 * Returns the current board grid
	 * @return hashmap containing the board
	 */
	public HashMap<Integer, HashMap<Integer, BoardCell>> getBoard() {
		return boardGrid;
	}
	
	/**
	 * Returns the cell at a given position
	 * @param x, the cell X pos
	 * @param y, the cell Y pos
	 * @return, the cell object itself
	 * @throws Exception if no cell was found in that index
	 */
	public BoardCell getCell(int x, int y) {
		if(boardGrid.containsKey(y)) {
			
			HashMap<Integer, BoardCell> boardRow = boardGrid.get(y);
			if(boardRow.containsKey((int)x)) {
				if(DataStorage.debugEnabled()) {
					System.out.printf("[GameBoard]: Getting cell [y: %d, x: %d], it has [%s] in it.\n", x, y, boardRow.get(x).getItem());
				}
				return boardRow.get(x);
			}
			else {
				// If we're going into -1 the board start
				if(x < boardStartX) {
					// We want to remove one from the end and cache it
					// In this case, we need to cache every cell on the X from each Y
				}
				
				// If we're going into +1 the board end
				if(x > boardEndX) {
					// We want to remove one from the start and cache it
					// In this case, we need to cache every cell on the X from each Y
				}
			}
			
		}
		else {
			if(DataStorage.debugEnabled()) {
				System.out.printf("[GameBoard]: Player has gone off the Y position into [y: %d, x: %d].\n", y, x);
			}
			// If we're going into -1 the board start
			if(y < this.boardStartY) {
				// Cache the row
				this.cachedObjects.put(this.boardEndY, this.boardGrid.get(this.boardEndY));
				this.boardGrid.remove(this.boardEndY);
				
				// Decrement
				this.boardEndY--;
				this.boardStartY--;
				
				// Check if the cached Y row exists
				if(this.cachedObjects.containsKey(y)) {
					// We want to add it directly back and keep everything it had before.
					this.boardGrid.put(y, this.cachedObjects.get(y));
					
					System.out.printf("[GameBoard]: Found cached row at [%d] and added it back to [%d].\n", y, this.boardStartY);
				}
				else {
					// Now make a new row at the end which starts from the startX to the endX into the new startY
					HashMap<Integer, BoardCell> newRow = new HashMap<Integer, BoardCell>();
					for(int i = this.boardStartX; i <= this.boardEndX; i++) {
						newRow.put(i, new BoardCell(CellItem.ITEM_NON, i, this.boardStartY));
					}
					this.boardGrid.put(this.boardStartY, newRow);
					
					if(DataStorage.debugEnabled()) {
						System.out.printf("[GameBoard]: Cached row [y: %d] and added new row at [y: %d], the new startY and endY are [sY: %d, eY: %d].\n", (this.boardEndY), this.boardStartY, this.boardStartY, this.boardEndY);
					}
				}
				
				// We can now return the new cell
				return this.boardGrid.get(y).get(x);
			}
			
			// If we're going into +1 the board end
			if(y > this.boardEndY) {
				
				System.out.println("END Y: " + this.boardEndY);
				
				// Cache the row
				this.cachedObjects.put(this.boardStartY, this.boardGrid.get(this.boardStartY));
				this.boardGrid.remove(this.boardStartY);

				// Increment
				this.boardStartY++;
				this.boardEndY++;
				
				// Check if the cached Y row exists
				if(this.cachedObjects.containsKey(y)) {
					// We want to add it directly back and keep everything it had before.
					this.boardGrid.put(y, this.cachedObjects.get(y));
					
					System.out.printf("[GameBoard]: Found cached row at [%d] and added it back to [%d].\n", y, this.boardEndY);
				}
				else {
					// Now make a new row at the end which starts from the startX to the endX into the new startY
					HashMap<Integer, BoardCell> newRow = new HashMap<Integer, BoardCell>();
					for(int i = this.boardStartX; i <= this.boardEndX; i++) {
						newRow.put(i, new BoardCell(CellItem.ITEM_NON, i, this.boardEndY));
					}
					this.boardGrid.put(this.boardEndY, newRow);

					if(DataStorage.debugEnabled()) {
						System.out.printf("[GameBoard]: Cached row [y: %d] and added new row at [y: %d], the new startY and endY are [sY: %d, eY: %d].\n", (this.boardStartY), this.boardEndY, this.boardStartY, this.boardEndY);
					}
				}
				
				// We can now return the new cell
				return this.boardGrid.get(y).get(x);
			}
		}

		return null;
	}
	
	/**
	 * Prints out the list of cells and items for debugging
	 */
	public void printBoard() {
		// Will only print if we have enabled debug messages
		if(DataStorage.debugEnabled()) {
			for(int i = this.boardStartY; i <= this.boardEndY; i++) {
				HashMap<Integer, BoardCell> row = this.boardGrid.get(i);
				for(int j = this.boardStartX; j <= this.boardEndX; j++) {
					BoardCell c = row.get(j);
					System.out.printf("[y: %d, x: %d, %s]", c.getY(), c.getX(), c.getItem());
				}
				System.out.println();
			}
		}
	}
	
}
