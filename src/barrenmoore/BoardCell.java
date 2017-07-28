package barrenmoore;

public class BoardCell {

	/**
	 * Variable definitions
	 */
	private CellItem cellItem = CellItem.ITEM_NONE;
	
	/**
	 * Constructs a new cell for the board
	 * @param ci, the item to put into the cell
	 */
	public BoardCell (CellItem ci) {
		this.cellItem = ci;
	}
	
	/**
	 * Gets the item in this cell
	 * @return, CellItem the item itself
	 */
	public CellItem getItem() {
		return cellItem;
	}
	
	/** 
	 * Sets the item in the cell
	 * @param i, the item to put into the cell
	 */
	public void setItem(CellItem ci) {
		if(DataStorage.debugEnabled()) {
			System.out.printf("[BoardCell]: Adding item [%s].\n", ci.toString());
		}
		
		this.cellItem = ci;
	}
}
