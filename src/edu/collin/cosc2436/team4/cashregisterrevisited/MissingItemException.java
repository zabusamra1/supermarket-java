package edu.collin.cosc2436.team4.cashregisterrevisited;

import edu.collin.cosc2436.team4.genericsmartshelf.RetailItem;

public class MissingItemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MissingItemException(RetailItem item) {
		super("Item is missing: " + item.getName());
	}
	
	

}
