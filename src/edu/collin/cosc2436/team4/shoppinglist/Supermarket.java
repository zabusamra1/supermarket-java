package edu.collin.cosc2436.team4.shoppinglist;

import java.util.HashMap;
import java.util.Map;

import edu.collin.cosc2436.team4.genericsmartshelf.RetailItem;
import edu.collin.cosc2436.team4.genericsmartshelf.SmartShelf;

/**
 * Represents a supermarket containing multiple smart shelves.
 * 
 * Each shelf is stored in a map using its name as the key.
 * 
 * The supermarket allows shelves to be added, removed, and searched by name.
 */
public class Supermarket {
	private final Map<String, SmartShelf<? extends RetailItem>> shelves = new HashMap<>();

    /**
     * Adds a smart shelf to the supermarket.
     * @param shelf the shelf to add.
     */
    public void addShelf(SmartShelf<? extends RetailItem> shelf) {
        shelves.put(shelf.getName(), shelf);
    }

    /**
     * Removes a smart shelf from the supermarket.
     * @param shelfName the name of the shelf to remove.
     * @return true if the shelf was found and removed, false otherwise.
     */
    public boolean remove(String shelfName) {
        if (shelves.containsKey(shelfName)) {
            shelves.remove(shelfName);
            return true;
        }

        return false;
    }

    /**
     *  Finds a smart shelf by its name.
     * @param name the name of the shelf.
     * @return the SmartShelf if found,or null if it does not exist.
     */
    public SmartShelf<? extends RetailItem> findShelf(String name) {
    	return shelves.get(name);
    }
}
