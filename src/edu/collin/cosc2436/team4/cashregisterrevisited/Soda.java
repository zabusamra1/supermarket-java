package edu.collin.cosc2436.team4.cashregisterrevisited;

import edu.collin.cosc2436.team4.genericsmartshelf.RetailItem;
import edu.collin.cosc2436.team4.genericsmartshelf.RetailItemType;

/**
 * A taxable Soda retail item
 */
public class Soda extends RetailItem {

	/**
	 * Constructor
	 * @param name The name of the soda
	 */
	public Soda(String name) {
		super(name, RetailItemType.SODA);
	}
}
