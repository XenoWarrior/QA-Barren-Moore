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
				
				boardRow.put(j, new BoardCell(CellItem.ITEM_NONE));
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
			if(boardRow.containsKey(x)) {
				if(DataStorage.debugEnabled()) {
					System.out.printf("[GameBoard]: Getting cell [%d, %d], it has [%s] in it.\n", x, y, boardRow.get(x).getItem());
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
				System.out.printf("[GameBoard]: Player has gone off the Y position into [%d, %d].\n", y, x);

				// If we're going into -1 the board start
				if(y < boardStartY) {
					// We want to remove one from the end and cache it
					this.cachedObjects.put(boardEndY, this.boardGrid.get(boardEndY));
					this.boardGrid.remove(boardEndY);
					this.boardEndY--;
				}
				
				// If we're going into +1 the board end
				if(y > boardEndY) {
					// We want to remove one from the start and cache it
					this.cachedObjects.put(boardStartY, this.boardGrid.get(boardStartY));
					this.boardGrid.remove(boardStartY);
					this.boardStartY++;
				}
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
			for(int i = boardStartY; i < boardGrid.size(); i++) {
				for(int j = boardStartX; j < boardGrid.size(); j++) {
					HashMap<Integer, BoardCell> row = boardGrid.get(i);
					BoardCell cell = row.get(j);
		
					System.out.printf("[GameBoard]: The item at [%d, %d] is a cell with item [%s]\n", i, j, cell.getItem());
				}
			}
		}
	}
	
}
