package edu.collin.cosc2436.team4.shoppingcart;

import edu.collin.cosc2436.team4.genericsmartshelf.RetailItem;

/**
 * 
 */
public class ShoppingCart {
	private final int cartID;
	private final MyStack<RetailItem> contents = new MyArrayStack<>();
	
	/**
	 * @param cartID
	 */
	public ShoppingCart(int cartID) {
		this.cartID = cartID;
	}

	/**
	 * @return the cartID
	 */
	public int getCartID() {
		return cartID;
	}
	
	/**
	 * @return
	 */
	public boolean isEmpty() {
		return contents.isEmpty();
	}
	
	/**
	 * @param item
	 */
	public void put(RetailItem item) {
		contents.push(item);
	}
	
	public RetailItem take() {
		if (isEmpty())
			throw new IllegalStateException();
		
		return contents.pop();
	}
}