package edu.collin.cosc2436.team4.shoppingcart;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

import edu.collin.cosc2436.team4.cashregisterrevisited.MissingCategoryException;
import edu.collin.cosc2436.team4.cashregisterrevisited.MissingItemException;
import edu.collin.cosc2436.team4.cashregisterrevisited.RetailItemLookup;
import edu.collin.cosc2436.team4.genericsmartshelf.RetailItem;
import edu.collin.cosc2436.team4.promotions.ActivePromotions;
import edu.collin.cosc2436.team4.promotions.Promotion;
/**
 * The CashRegister class simulates a cash register.
 * It records purchased items, calculates totals,
 * and prints a formatted receipt.
 */
public class CashRegister {
	
	 /** Shared RetailItemLookup used by all CashRegister objects */
	private static RetailItemLookup retailItemLookup;
	
	private static ActivePromotions activePromotions;
	
	 /** List of purchased items for a single transaction */
	private ArrayList<RetailItem> purchasedItems;
	
	/**
     * Sets the shared RetailItemLookup object.
     *
     * @param lookup The RetailItemLookup to use
     */
	public static void setRetailItemLookup(RetailItemLookup lookup)
	{
		retailItemLookup = lookup;
	}
	
	 /**
     * Starts a new transaction by creating a new list
     * of purchased items.
     */
	public void startTransaction()
	{
		purchasedItems = new ArrayList<RetailItem>();
	}

	 /**
     * Adds a retail item to the transaction.
     *
     * @param item The retail item to scan
     */
	public void scanItem(RetailItem item)
	{
		purchasedItems.add(item);
	}
	
	 /**
     * Prints a formatted receipt showing each purchased item,
     * its price, the subtotal, tax, and total.
     */
	public String printReceipt() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		double subtotal = 0;
		double tax = 0;
		Iterator <RetailItem> itr = purchasedItems.iterator();
		while(itr.hasNext()) {
			RetailItem item = itr.next();
			try {
				double itemPrice = retailItemLookup.lookupPrice(item);
				double itemTax = retailItemLookup.computeTax(item);
				out.println(item.getName() + "         $ " + itemPrice);

				Promotion bestPromo = activePromotions.determineBestPromotion(item);
				if(bestPromo != null){
					int discountPercentage = bestPromo.getDiscountPercentage();
					double discount = discountPercentage * itemPrice;
					out.println("   Promo:" + bestPromo.getName() + "  -$ " + discount);
					itemTax *= 1-discountPercentage/100f;
					itemPrice -= discount;
				}
				subtotal += itemPrice;
				tax += itemTax;
			}catch(MissingCategoryException | MissingItemException e){
				out.println(item.getName() + "      " + e);
				itr.remove();
			}
		}
		double total = subtotal+tax;
		
		out.println("                 ");
        out.printf("Subtotal $ %.2f%n", subtotal);
        out.printf("Tax $ %.2f%n", tax);
        out.printf("Total $ %.2f%n", total);
        out.println("----------------");
        return stream.toString();
	}
	
}