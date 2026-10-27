package edu.collin.cosc2436.team4.shoppingcart;

import edu.collin.cosc2436.team4.genericsmartshelf.RetailItem;

/**
 * 
 */
public class Cashier {
	private final String name;

	/**
	 * @param name
	 */
	public Cashier(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	public void handleCheckoutCounter(CheckoutCounter counter) {
		Customer customer = counter.getCustomer();
		CashRegister register = counter.getRegister();
		
		System.out.println(getName() + " is checking if there is a customer ready");
		
		if (customer != null) {
			System.out.println(getName() + " is checking out " + customer.getName());
			
			register.startTransaction();
			ShoppingCart cart = customer.getCart();
			
			while(!cart.isEmpty()) {
				RetailItem item = cart.take();
				
				System.out.println(getName() + " is scanning " + item.getName());
				register.scanItem(item);
			}
			
			customer.takeRecipt(register.printReceipt());
		} else {
			System.out.println("There is no customer ready to check out");
		}
	}
}