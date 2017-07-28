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
			for(int j = 0; j < size; j++) {
				System.out.printf("[GameBoard]: Made new cell at [%d, %d] with item [%s]\n", i, j, new BoardCell(CellItem.ITEM_NONE).getItem());
			}
		}
		
	}
	
}
