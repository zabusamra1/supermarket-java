package edu.collin.cosc2436.team4.smartshelf;

import java.util.ArrayList;

/**
 * Interface representing actions a supermarket employee can perform
 * on a smart shelf.
 */
public interface IShelfEmployee {
	
	/**
	 * Places a collection of unsorted items on the shelf.
	 * @param items Unsorted list of retail items
	 */
	public void placeItems(ArrayList<RetailItem> items);
	
	/**
	 * Adds a single item to the shelf while preserving
	 * sorted order.
	 * @param item Item to add
	 */
	public void addItem(RetailItem item);

}
