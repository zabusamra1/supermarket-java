package edu.collin.cosc2436.team4.smartshelf;

import java.util.ArrayList;

/**
 * Represents a supermarket employee responsible 
 * for stocking items on shelf.
 */
public class Employee {
	
	/**
	 * Places unsorted items on the shelf.
	 * @param shelf
	 * @param items
	 */
	public void placeItems(IShelfEmployee shelf, ArrayList<RetailItem> items) {
		System.out.println("----------Employee placing on the shelf");
		
		for (RetailItem item : items) {
			System.out.println(item.getName());
		}
		
		shelf.placeItems(items);
		
		System.out.println();
		System.out.println("----------Placed on the shelf:");
        System.out.println(shelf);
	}
	
	/**
	 * Adds new item to the shelf.
	 * @param shelf
	 * @param item
	 */
	public void addItem(IShelfEmployee shelf, RetailItem item) {
		System.out.println("----------Employee adding " + item.getName());
		shelf.addItem(item);
	}

}
