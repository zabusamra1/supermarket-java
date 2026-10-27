package edu.collin.cosc2436.team4.cashregisterrevisited;

import java.util.HashMap;
import java.util.Map;

import edu.collin.cosc2436.team4.genericsmartshelf.RetailItem;
import edu.collin.cosc2436.team4.genericsmartshelf.RetailItemType;

/**
 * The RetailItemLookup class provides prices and tax values
 * for retail items. It is used by the CashRegister class.
 */
public class RetailItemLookup {
	private final double taxRate;
	private final Map<RetailItemType, PricingCategory> prices;
	
	 /**
     * Constructor
     *
     * @param rate The sales tax rate
     * @param priceArray The prices for the retail items
     */
	public RetailItemLookup(double rate) {
		taxRate = rate;
		
		prices = new HashMap<>();
			
		}
	
	/**
	 * @param itemType
	 * @param taxable
	 * @throws DuplicateCategoryException
	 */
	public void addPricingCategory(RetailItemType itemType,boolean taxable) throws DuplicateCategoryException {
			if(prices.containsKey(itemType)) {
				throw new DuplicateCategoryException(itemType);
			}
			   prices.put(itemType, new PricingCategory(taxable));
			   System.out.println("Added a pricing category for " + itemType);
		}
	
	/**
	 * @param removePriceCat
	 */
	public void removePricingCategory(RetailItemType removePriceCat) {
		prices.remove(removePriceCat);
		
	}
	
	/**
	 * @param itemToAdd
	 * @param price
	 * @throws MissingCategoryException
	 */
	public void addItem(RetailItem itemToAdd, double price) throws MissingCategoryException {
		PricingCategory category = findPricingCat(itemToAdd);
	        category.addItem(itemToAdd, price);
	        System.out.println("Added "+ itemToAdd.getName() + ": $" + price + " to "+ itemToAdd.getType());
		
	}

	/**
	 * @param item
	 * @return
	 * @throws MissingCategoryException
	 */
	private PricingCategory findPricingCat(RetailItem item) throws MissingCategoryException {
		if(! prices.containsKey(item.getType())) {
			throw new MissingCategoryException(item);		
		}
		return prices.get(item.getType());
	}
	
	/**
	 * Returns the price of a retail item.
	 *
	 * @param item The retail item
	 * @return The price of the item
	 * @throws MissingItemException 
	 */
	public double lookupPrice(RetailItem item) throws MissingCategoryException, MissingItemException {		
		    PricingCategory category = findPricingCat(item);
		    return category.lookupItemPrice(item);
		}
	
	  /**
     * Computes the tax for a retail item.
     *
     * @param item The retail item
     * @return The tax amount
	 * @throws MissingCategoryException 
	 * @throws MissingItemException 
     */
	public double computeTax(RetailItem item) throws MissingCategoryException, MissingItemException {
		PricingCategory category = findPricingCat(item);
		if(category.isTaxable()) {
			return lookupPrice(item) * taxRate;		
		}
		return 0;
	}
}