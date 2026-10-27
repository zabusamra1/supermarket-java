package edu.collin.cosc2436.team4.smartshelf;

/**
 * Represents a retail item stored on a smart shelf.
 * Items are compared alphabetically by name.
 */
public class RetailItem implements Comparable<RetailItem> {
	
	private final String name;
	
	/**
	 * Constructs a retail item with a given name.
	 * @param name
	 */
	public RetailItem(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the name of the item.
	 * @return Item name
	 */
	public String getName() {
		return name;
	}
	
	/** 
	 * @param itemToCompare The other item to sort alphabetically compared to this one
	 * @return The alphabetical sort order (see compareToIgnoreCase)
	 */
	@Override
	public int compareTo(RetailItem itemToCompare) {
		return name.compareToIgnoreCase(itemToCompare.name);
	}
	
	/**
	 * returns item name.
	 *
	 */
	public String toString() {
		return name;
	}

}
