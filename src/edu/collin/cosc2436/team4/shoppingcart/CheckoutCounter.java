package edu.collin.cosc2436.team4.shoppingcart;

/**
 * 
 */
public class CheckoutCounter {
	private final CashRegister register;
	private Customer customer;
	
	/**
	 * @param register
	 */
	public CheckoutCounter(CashRegister register) {
		this.register = register;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the register
	 */
	public CashRegister getRegister() {
		return register;
	}
}