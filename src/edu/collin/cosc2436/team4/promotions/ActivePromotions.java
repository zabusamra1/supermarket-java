package edu.collin.cosc2436.team4.promotions;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import edu.collin.cosc2436.team4.genericsmartshelf.RetailItem;

/**
 * This class tracks active promotions
 */
public class ActivePromotions {
	private final List<Promotion> activePromotions = new LinkedList<>();
	
	/**
	 * Adds a promotion to the active promotions
	 * @param newPromotion THe promotion to add
	 */
	public void addPromotion(Promotion newPromotion) {
		activePromotions.add(newPromotion);
		System.out.println("Added promotion " +newPromotion.getName());
	}
	
	/**
	 * Removes a promotion with the specified name (if found) from the active promotions
	 * @param name The name of the promotion to remove
	 */
	public void removePromotion(String name) {
		Iterator<Promotion> iter = activePromotions.iterator();
		
		while (iter.hasNext()) {
			if (iter.next().getName() == name) {
				iter.remove();
				System.out.println("Removed " + name);
			}
		}
	}
	
	/**
	 * Checks all promotions to see if they are expired and removes them if they are.
	 */
	public void removeExpiredPromotions(LocalDate currentDate) {
		Iterator<Promotion> iter = activePromotions.iterator();
		
		while (iter.hasNext()) {
			if (iter.next().getExpirationDate().isBefore(currentDate))
				iter.remove();
		}
		
		System.out.println("Remove expired");
	}
	
	/**
	 * Determines the best promotions for an item.
	 * @param item The item to determine the promotion for
	 * @return The Promotion offering the highest discount
	 */
	public Promotion determineBestPromotion(RetailItem item) {
		int bestDiscount = 0;
		Promotion bestPromotion = null;
		
		for (Promotion promo : activePromotions) {
			int discount = promo.determineDiscount(item);
			if(discount > bestDiscount) {
				bestDiscount = discount;
				bestPromotion = promo;
			}
		}
		
		return bestPromotion;
	}
}
