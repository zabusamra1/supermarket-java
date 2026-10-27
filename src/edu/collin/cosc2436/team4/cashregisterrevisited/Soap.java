package edu.collin.cosc2436.team4.cashregisterrevisited;

import edu.collin.cosc2436.team4.genericsmartshelf.RetailItem;
import edu.collin.cosc2436.team4.genericsmartshelf.RetailItemType;

/**
 * A taxable Soap retail item
 */
public class Soap extends RetailItem {

	/**
	 * Constructor
	 * @param name The name of the soap
	 */
	public Soap(String name) {
		super(name, RetailItemType.SOAP);
	}
}
