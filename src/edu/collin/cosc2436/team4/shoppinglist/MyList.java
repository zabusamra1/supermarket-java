package edu.collin.cosc2436.team4.shoppinglist;

/**
 * Custom generic list interface that defines basic operations
 * for a linked list implementation.
 * 
 * This list supports adding elements to the front or back,
 * removing elements, checking if it is empty, and iteration.
 * 
 * @param <T> the type of elements stored in the list.
 */
public interface MyList<T> extends Iterable<T> {
	/**
	 * Checks whether the list is empty.
	 * @return true if the list contains no elements, false otherwise
	 */
	public boolean isEmpty();
	
	
	/**
	 * Adds an element to the beginning of the list.
	 * 
	 * @param element element the element to add.
	 */
	public void addFirst(T element);
	
	
	/**
	 * Adds an element to the end of the list.
	 * @param element element the element to add.
	 */
	public void addLast(T element);
	
	
	/**
	 * Removes the first occurrence of the specified element from the list.
	 * 
	 * @param element element the element to remove.
	 * 
	 * @return true if the element was found and removed, false otherwise.
	 */
	public boolean remove(T element);
	
	
}
