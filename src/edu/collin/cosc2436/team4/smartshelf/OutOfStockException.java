package edu.collin.cosc2436.team4.smartshelf;

/**
 * Exception thrown when a requested item is not avaliable
 *  on the shelf.
 * 
 */
public class OutOfStockException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4955226115843286687L;
	
	/**
	 * Constructs the exception with a message
	 * @param outOfStockItemName Name of the missing item
	 */
	public OutOfStockException(String outOfStockItemName) {
		super (outOfStockItemName + " is out of stock");
	}
	

}
