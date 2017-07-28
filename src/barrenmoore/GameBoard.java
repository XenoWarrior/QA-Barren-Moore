package barrenmoore;

import java.util.HashMap;

public class GameBoard {

	/**
	 * Variable definitions
	 */
	private HashMap<Integer, HashMap<Integer, BoardCell>> boardGrid = new HashMap<Integer, HashMap<Integer, BoardCell>>();
	private HashMap<Integer, BoardCell> boardRow = new HashMap<Integer, BoardCell>();
	
	/**
	 * Constructs a new game board
	 * @param size
	 */
	public GameBoard(int size) {
		// Generate a new board
		for(int i = 0; i < size; i++) {
			// Clear any previous row
			boardRow.clear();
			for(int j = 0; j < size; j++) {
				// Put new cell into row
				boardRow.put(j, new BoardCell(CellItem.ITEM_NONE));
			}
			// Add the row
			boardGrid.put(i, boardRow);
		}
	}
	
	public HashMap<Integer, HashMap<Integer, BoardCell>> getBoard() {
		return boardGrid;
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
