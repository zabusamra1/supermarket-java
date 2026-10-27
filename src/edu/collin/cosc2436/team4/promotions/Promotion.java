package edu.collin.cosc2436.team4.promotions;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

import edu.collin.cosc2436.team4.genericsmartshelf.RetailItem;

/**
 * A class representing a promotion (Sale).
 */
public class Promotion {
	private final String name;
	private final int discountPercentage;
	private final LocalDate expirationDate;
	private final HashSet<RetailItem> promotionItems = new HashSet<>();
	
	/**
	 * Constructor
	 * @param name The promotion name
	 * @param discountPercentage The Promotion discount percentage in decimal from
	 * @param expirationDate The expiration date of the promotion
	 */
	public Promotion(String name, int discountPercentage, LocalDate expirationDate) {
		this.name = name;
		this.discountPercentage = discountPercentage;
		this.expirationDate = expirationDate;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the discountPercentage
	 */
	public int getDiscountPercentage() {
		return discountPercentage;
	}

	/**
	 * @return the expirationDate
	 */
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	
	/**
	 * Determines the discount offered by this promotion for the RetailItem provided
	 * @param item The RetailItem to determine the discount for.
	 * @return The discount as a decimal for the item.
	 */
	public int determineDiscount(RetailItem item) {
		if (promotionItems.contains(item))
			return discountPercentage;
		
		return 0;
	}
	
	/**
	 * Adds an item to the promotion
	 * @param itemToAdd The item to add
	 */
	public void addItem(RetailItem itemToAdd) {
		promotionItems.add(itemToAdd);
	}
	
	/**
	 * Adds a collection of items to the promotion all at once.
	 * @param <T> The type of items in the collection
	 * @param itemsToAdd The collection to add
	 */
	public <T extends RetailItem> void addAllItems(Collection<T> itemsToAdd) {
		promotionItems.addAll(itemsToAdd);
	}
}
