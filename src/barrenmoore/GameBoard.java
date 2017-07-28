package barrenmoore;

import java.util.HashMap;

public class GameBoard {

	/**
	 * Variable definitions
	 */
	private HashMap<Integer, HashMap<Integer, BoardCell>> boardGrid = new HashMap<Integer, HashMap<Integer, BoardCell>>();
	
	/**
	 * Constructs a new game board
	 * @param size
	 */
	public GameBoard(int size) {
		// Generate a new board
		for(int i = 0; i < size; i++) {
			HashMap<Integer, BoardCell> boardRow = new HashMap<Integer, BoardCell>();
			for(int j = 0; j < size; j++) {
				boardRow.put(j, new BoardCell(CellItem.ITEM_NONE));
			}
			boardGrid.put(i, boardRow);
		}
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
	public BoardCell getCell(int x, int y) throws Exception {
		if(boardGrid.containsKey(y)) {
			HashMap<Integer, BoardCell> boardRow = boardGrid.get(y);
			if(boardRow.containsKey(x)) {
				if(DataStorage.debugEnabled()) {
					System.out.printf("[GameBoard]: Getting cell [%d, %d], it has [%s] in it.\n", x, y, boardRow.get(x).getItem());
				}
				return boardRow.get(x);
			}
		}

		throw new Exception("No cell found!");
	}
	
	/**
	 * Prints out the list of cells and items for debugging
	 */
	public void printBoard() {
		// Will only print if we have enabled debug messages
		if(DataStorage.debugEnabled()) {
			for(int i = 0; i < boardGrid.size(); i++) {
				for(int j = 0; j < boardGrid.size(); j++) {
					HashMap<Integer, BoardCell> row = boardGrid.get(i);
					BoardCell cell = row.get(j);
		
					System.out.printf("[GameBoard]: The item at [%d, %d] is a cell with item [%s]\n", i, j, cell.getItem());
				}
			}
		}
	}
	
}
