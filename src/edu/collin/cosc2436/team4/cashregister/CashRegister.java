package edu.collin.cosc2436.team4.cashregister;
import java.util.ArrayList;

/**
 * The CashRegister class simulates a cash register.
 * It records purchased items, calculates totals,
 * and prints a formatted receipt.
 */
public class CashRegister {
	
	 /** Shared RetailItemLookup used by all CashRegister objects */
	private static RetailItemLookup retailItemLookup;
	
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
     * Calculates the subtotal for the transaction.
     *
     * @return The subtotal amount
     */
	private double calculateSubtotal()
	{
		double subtotal = 0.0;
		
		for (RetailItem item : purchasedItems)
		{
			subtotal += retailItemLookup.lookupPrice(item);
		}
		
		return subtotal;
	}
	
	 /**
     * Calculates the total tax for the transaction.
     *
     * @return The tax amount
     */
	private double calculateTax()
	{
		double tax = 0.0;
		
		for (RetailItem item : purchasedItems)
		{
			tax += retailItemLookup.computeTax(item);
		}
		
		return tax;
	
	}
	
	 /**
     * Prints a formatted receipt showing each purchased item,
     * its price, the subtotal, tax, and total.
     */
	public void printReceipt() {
		
		double subtotal = calculateSubtotal();
		double tax = calculateTax();
		double total = subtotal+tax;
		
		for (RetailItem item : purchasedItems) {
            System.out.printf("%s $ %.2f%n", item, retailItemLookup.lookupPrice(item));
        }
		System.out.println("                 ");
        System.out.printf("Subtotal $ %.2f%n", subtotal);
        System.out.printf("Tax $ %.2f%n", tax);
        System.out.printf("Total $ %.2f%n", total);
        System.out.println("----------------");
		
		
		
		}
	
		}
