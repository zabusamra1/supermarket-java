package edu.collin.cosc2436.team4.cashregisterrevisited;

import java.util.HashMap;
import java.util.Map;
import edu.collin.cosc2436.team4.genericsmartshelf.RetailItem;

/**
 * Represents a category of price which retail items can be members of.
 */
public class PricingCategory {
	private final boolean taxable;
	private final Map<RetailItem, Double> map;
	
	/**
	 * Constructor
	 * @param taxable is the category taxable
	 */
	public PricingCategory(boolean taxable) {
		this.taxable = taxable;
		map = new HashMap<RetailItem, Double>();
	}

	/**
	 * @return is the category taxable
	 */
	public boolean isTaxable() {
		return taxable;
	}
	
	/**
	 * @param itemToAdd
	 * @param price
	 */
	public void addItem(RetailItem itemToAdd, double price) {
		map.put(itemToAdd, price);
	}
	
	/**
	 * @param lookupItem
	 * @return
	 * @throws MissingItemException
	 */
	public double lookupItemPrice(RetailItem lookupItem) throws MissingItemException{
		if (!map.containsKey(lookupItem))
			throw new MissingItemException(lookupItem);
		
		return map.get(lookupItem);
	}
	
	/**
	 * @param itemRemove
	 */
	public void removeItem(RetailItem itemRemove) {
		map.remove(itemRemove);
		
	}
}
