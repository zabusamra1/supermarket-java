/**
 * @author Josiah English, Zaid N. M. Abusamra, Josh Fletcher
 * Class: Programming Fundamentals III
 * Meeting Times: M/W
 */
package edu.collin.cosc2436.team4.promotions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import edu.collin.cosc2436.team4.genericsmartshelf.Cereal;
import edu.collin.cosc2436.team4.genericsmartshelf.Chips;
import edu.collin.cosc2436.team4.genericsmartshelf.RetailItem;
import edu.collin.cosc2436.team4.genericsmartshelf.SmartShelfDemo;

/**
 * The demo program for promotions
 */
public class PromotionDemo {
	public static void main(String[] args) {
		// Import Resources
		ArrayList<Cereal> cerealItems = new ArrayList<>();
		ArrayList<Chips> chipsItems = new ArrayList<>();
		
		Scanner cerealScanner = new Scanner (SmartShelfDemo.class.getResourceAsStream("/cereal.txt"));
		Scanner chipsScanner = new Scanner (SmartShelfDemo.class.getResourceAsStream("/chips.txt"));
		
		while (cerealScanner.hasNext()) {
			cerealItems.add(new Cereal(cerealScanner.nextLine()));
		}
		
		while (chipsScanner.hasNext()) {
			chipsItems.add(new Chips(chipsScanner.nextLine()));
		}
		
		cerealScanner.close();
		chipsScanner.close();
		
		// Main Functionality
		Promotion easter = new Promotion("Easter", 20, LocalDate.of(2026, 4, 6));
		Promotion mothersDay = new Promotion("Mother's Day", 10, LocalDate.of(2026, 5, 10));
		Promotion valentinesDay = new Promotion("Valentine's Day", 5, LocalDate.of(2026, 2, 14));
		
		mothersDay.addAllItems(chipsItems);
		valentinesDay.addAllItems(cerealItems);
		
		for (int i = 0; i < cerealItems.size(); i += 2) {
			easter.addItem(cerealItems.get(i));
		}
		
		for (int i = 0; i < chipsItems.size(); i += 2) {
			easter.addItem(chipsItems.get(i));
		}
		
		ActivePromotions activePromos = new ActivePromotions();
		activePromos.addPromotion(easter);
		activePromos.addPromotion(mothersDay);
		activePromos.addPromotion(valentinesDay);
		
		System.out.println("Cereals:");
		printBestPromos(cerealItems, activePromos);
		
		System.out.println();
		System.out.println("Chips:");
		printBestPromos(chipsItems, activePromos);
		
		System.out.println();
		activePromos.removeExpiredPromotions(LocalDate.now());
		
		System.out.println();		
		System.out.println("Cereals:");
		printBestPromos(cerealItems, activePromos);
		
		System.out.println();
		System.out.println("Chips:");
		printBestPromos(chipsItems, activePromos);

		System.out.println();
		activePromos.removePromotion("Easter");
		
		System.out.println();
		System.out.println("Cereals:");
		printBestPromos(cerealItems, activePromos);
		
		System.out.println();
		
		System.out.println("Chips:");
		printBestPromos(chipsItems, activePromos);

	}

	/**
	 * Prints out a list of products with the promo info for their best promos. Prints "No Active Promo" if there isn't one for that item
	 * @param <T> The type of items (Must Extend RetailItem)
	 * @param items The items print promos for
	 * @param promos The list of current active promos
	 */
	private static <T extends RetailItem> void printBestPromos(ArrayList<T> items, ActivePromotions promos) {
		for (RetailItem item : items) {
			Promotion bestPromo = promos.determineBestPromotion(item);
			
			if (bestPromo != null) {
				System.out.printf("%-25s %-15s  Expires: %10s     %d%%\n", item.getName(), bestPromo.getName(), bestPromo.getExpirationDate(),
					bestPromo.getDiscountPercentage());
			} else {
				System.out.printf("%-25s No Active Promos\n", item.getName());
			}
		}
	}
}
