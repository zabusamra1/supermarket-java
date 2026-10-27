package edu.collin.cosc2436.team4.genericsmartshelf;

import edu.collin.cosc2436.team4.smartshelf.OutOfStockException;

/**
 * Represents a supermarket customer interacting with
 * a smart shelf.
 */
public class Customer {
	private final String name;
	
	/**
	 * Constructor
	 * @param name The name of the customer
	 */
	public Customer(String name) {
		this.name = name;
	}
	
	/**
	 * Attempts to get an item from the shelf.
	 * @param shelf
	 * @param itemToGet
	 */
	public <M extends RetailItem> void takeItem(IShelfCustomer<M> shelf, String itemToGet, RetailItemType type) {
		System.out.println(getName() + " getting from " + shelf.getName()  + ": " + itemToGet);
		
		try {
			RetailItem item = shelf.findAndTake(itemToGet, type);
			
			System.out.println(getName() + " got " + item.getName());
		}
		catch(OutOfStockException e) {
			
			System.out.println(e);
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
