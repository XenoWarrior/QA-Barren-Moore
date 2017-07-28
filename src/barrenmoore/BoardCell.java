package barrenmoore;

public class BoardCell {

	/**
	 * Variable definitions
	 */
	private CellItem cellItem = CellItem.ITEM_NON;
	private int cellX;
	private int cellY;
	
	/**
	 * Constructs a new cell for the board
	 * @param ci, the item to put into the cell
	 * @param cx, the cell X pos
	 * @param cy, the cell Y pos
	 */
	public BoardCell (CellItem ci, int cx, int cy) {
		this.cellItem = ci;

		this.cellX = cx;
		this.cellY = cy;
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

	/**
	 * Sets the X position of this cell
	 * @param x, the new X value
	 */
	public void setX(int x) {
		this.cellX = x;
	}
	
	/**
	 * Sets the Y position of this cell
	 * @param y, the new Y value
	 */
	public void setY(int y) {
		this.cellY = y;
	}
	
	/**
	 * Gets the X position of this cell
	 * @return int, the X pos
	 */
	public int getX() {
		return this.cellX;
	}
	
	/**
	 * Gets the Y position of this cell
	 * @return int, the Y pos
	 */
	public int getY() {
		return this.cellY;
	}
	
}
