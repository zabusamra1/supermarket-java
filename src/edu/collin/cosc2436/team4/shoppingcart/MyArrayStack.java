package edu.collin.cosc2436.team4.shoppingcart;

import java.util.EmptyStackException;

/**
 * @param <T>
 */
public class MyArrayStack<T> implements MyStack<T> {
	private final static int DEFAULT_INITIAL_CAPACITY = 20;
	private final static int DEFAULT_INCREMENT = 10;
	
	private Object[] arr;
	private int top = 0;
	
	private final int increment;
	
	
	/**
	 * @param initialCapacity
	 * @param increment
	 */
	public MyArrayStack(int initialCapacity, int increment) {
		if (increment <= 0)
			throw new IllegalArgumentException("Increment has to be posititive.");
		if (initialCapacity < increment)
			throw new IllegalArgumentException("Capacity must be at least as big as one increment.");
		
		this.increment = increment;
		arr = new Object[initialCapacity];
	}

	/**
	 * 
	 */
	public MyArrayStack() {
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_INCREMENT);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return top == 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T push(T element) {
		growIfNeeded();
		
		arr[top] = element;
		top++;
		
		return element;
	}

	/**
	 * 
	 */
	private void growIfNeeded() {
		if (top == arr.length) {
			Object[] newArr = new Object[arr.length + increment];
			
			for (int i = 0; i < arr.length; i++) {
				newArr[i] = arr[i];
			}
			
			arr = newArr;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T pop() {
		T ret = peek();
		
		top--;
		arr[top] = null;
		
		return ret;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T peek() {
		if (isEmpty())
			throw new EmptyStackException();
			
		return (T)arr[top - 1];
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return toStringRec(0).append("]").toString();
	}	
	
	/**
	 * @return
	 */
	private StringBuilder toStringRec(int idx) {
		if (idx == top)
			return new StringBuilder("[ ");
		
		return toStringRec(idx + 1).append(arr[idx]).append(" ");
	}
}