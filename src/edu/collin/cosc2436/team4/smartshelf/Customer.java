package edu.collin.cosc2436.team4.smartshelf;

/**
 * Represents a supermarket customer interacting with
 * a smart shelf.
 */
public class Customer {
	
	/**
	 * Attempts to get an item from the shelf.
	 * @param shelf
	 * @param itemToGet
	 */
	public void getItem(IShelfCustomer shelf, String itemToGet) {
		System.out.println("----------Customer getting " + itemToGet);
		
		try {
			RetailItem item = shelf.findAndTake(itemToGet);
			
			System.out.println("----------Got " + item.getName());
		}
		catch(OutOfStockException e) {
			
			System.out.println(e);
            System.out.println(shelf);
		}
	}

}
