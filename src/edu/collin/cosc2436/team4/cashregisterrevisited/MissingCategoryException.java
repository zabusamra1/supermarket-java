package edu.collin.cosc2436.team4.cashregisterrevisited;

import edu.collin.cosc2436.team4.genericsmartshelf.RetailItem;

public class MissingCategoryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MissingCategoryException(RetailItem item) {
		super("Category is missing for " + item.getName());
	}
	
	

}
