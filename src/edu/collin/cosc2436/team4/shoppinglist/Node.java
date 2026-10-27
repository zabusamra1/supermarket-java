package edu.collin.cosc2436.team4.shoppinglist;

/**
 * A generic node used in a singly linked list implementation.
 * 
 * Each node stores a value and a reference to the next node in the list.
 * 
 * @param <T> the type of value stored in the node.
 */
public class Node<T> {
	public final T value;
	public Node<T> next;

    /**Constructs a node with the given value and no next node.
     * @param value the value to store in this node.
     */
    public Node(T value) {
        this(value, null);
    }
	
	/**
	 * Constructs a node with the given value and next node reference.
	 * @param value the value to store in this node
	 * @param next the next node in the list.
	 */
	public Node(T value, Node<T> next) {
		this.value = value;
		this.next = next;
	}

	/**
	 * Returns the next node in the list.
	 * @return next the next node.
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * Sets the next node reference.
	 * @param next the node to set as next. 
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

	/**
	 * Returns the value stored in this node.
	 * @return value sets the node value.
	 */
	public T getValue() {
		return value;
	}
}