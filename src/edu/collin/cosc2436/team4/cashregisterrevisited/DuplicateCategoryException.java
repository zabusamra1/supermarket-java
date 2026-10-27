package edu.collin.cosc2436.team4.cashregisterrevisited;

import edu.collin.cosc2436.team4.genericsmartshelf.RetailItemType;

public class DuplicateCategoryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateCategoryException(RetailItemType itemType) {
		super("Category already exists for " + itemType);
	}
	
	

}
