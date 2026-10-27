package edu.collin.cosc2436.team4.genericsmartshelf;

import edu.collin.cosc2436.team4.smartshelf.OutOfStockException;

/**
 * Interface representing actions a supermarket customer can 
 * perform on a smart shelf
 */
public interface IShelfCustomer<T extends RetailItem> extends IShelf {
	
	/**
	 * Finds an item with the given name and removes it
	 * from the shelf.
	 * @param name of the desired item
	 * @return the item removed from the shelf
	 * @throws OutOfStockException if the item is not found
	 */
	public T findAndTake(String name, RetailItemType type) throws OutOfStockException;
}
