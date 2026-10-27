package edu.collin.cosc2436.team4.genericsmartshelf;

/**
 * Represents a retail item stored on a smart shelf.
 * Items are compared alphabetically by name.
 */
public class RetailItem {
	private final String name;
	private final RetailItemType type;
	
	/**
	 * Constructs a retail item with a given name.
	 * @param name
	 */
	public RetailItem(String name, RetailItemType type) {
		this.name = name;
		this.type = type;
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
	public int compareTo(RetailItem itemToCompare) {
		String identity = type + name;
		return identity.compareToIgnoreCase(itemToCompare.type + itemToCompare.name);
	}
	
	/**
	 * returns item name.
	 *
	 */
	public String toString() {
		return name;
	}
	
	/**
	 * Calculates the hash code for this item.
	 */
	@Override
    public int hashCode() {
        int ret = 17;
        ret = 31 * ret + name.hashCode();
        ret = 31 * ret + type.hashCode();
        return ret;
    }

	/**
	 * Determines if another object is equal to this one.
	 */
    @Override
    public boolean equals(Object obj) {
        boolean ret = false;
        if (obj instanceof RetailItem) {
            RetailItem item = (RetailItem) obj;
            ret = name.equals(item.name) && type==item.type;
        }
        return ret;
    }

	public Object getType() {
		return type;
	}
}
