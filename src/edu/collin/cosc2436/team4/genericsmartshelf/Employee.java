package edu.collin.cosc2436.team4.genericsmartshelf;

import java.util.List;

/**
 * Represents a supermarket employee responsible 
 * for stocking items on shelf.
 */
public class Employee {
	private final String name;
	
	/**
	 * Constructor
	 * @param name The name of the Employee
	 */
	public Employee(String name) {
		this.name = name;
	}
	
	/**
	 * Places unsorted items on the shelf.
	 * @param shelf
	 * @param items
	 */
	public <M extends RetailItem> void placeItems(IShelfEmployee<M> shelf, List<M> items) {
		System.out.println(getName() + " placing on the " + shelf.getName() + ":");
		
		for (RetailItem item : items) {
			System.out.println(item.getName());
		}
		
		shelf.placeItems(items);
	}
	
	/**
	 * Adds new item to the shelf.
	 * @param shelf
	 * @param item
	 */
	public <M extends RetailItem> void addItem(IShelfEmployee<M> shelf, M item) {
		System.out.println(getName() + " adding to " + shelf.getName() + ": " + item.getName());
		shelf.addItem(item);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
