package edu.collin.cosc2436.team4.shoppinglist;

import edu.collin.cosc2436.team4.genericsmartshelf.RetailItemType;


/**
 * Represents a single item in a customers shopping list.
 * 
 * each entry contains the item name,type and shelf location.
 * 
 */
public class ShoppingListEntry {
    private final String itemName;
    private final RetailItemType itemType;
    private final String shelfName;
    

	/**
	 * Constructs a ShoppingListEntry with item details.
	 * 
	 * @param itemName the name of the item.
	 * @param itemType the category/type of the item.
	 * @param shelfName the shelf where the item is located.
	 */
	public ShoppingListEntry(String itemName, RetailItemType itemType, String shelfName) {
		this.itemName = itemName;
		this.itemType = itemType;
		this.shelfName = shelfName;
	}
	
	/**Returns the item name.
	 * @return itemName The item name.
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * Returns the item type.
	 * @return itemType
	 */
	public RetailItemType getItemType() {
		return itemType;
	}
	
	/**
	 * Returns the shelf name.
	 * @return shelfName
	 */
	public String getShelfName() {
		return shelfName;
	}

	/**
	 * Returns a formatted representation of the shopping list entry.
	 * @return formatted shopping list entry
	 *
	 */
	@Override
	public String toString() {
		return getItemType().name() + ": " + getItemName() + " from " + getShelfName();
	}
}