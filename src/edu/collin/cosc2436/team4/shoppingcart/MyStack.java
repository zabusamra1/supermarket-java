package edu.collin.cosc2436.team4.shoppingcart;

/**
 * 
 */
public interface MyStack<T> {
	/**
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * @param element
	 * @return
	 */
	T push(T element);
	
	/**
	 * @return
	 */
	T pop();
	
	/**
	 * @return
	 */
	T peek();
}