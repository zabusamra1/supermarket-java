package edu.collin.cosc2436.team4.shoppinglist;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * A custom generic singly linked list implementation.
 * 
 * This list supports adding elements to the front and back, removing elements,
 * and interations using a custom iterator.
 * 
 * @param <T> the type of elements stored in the list.
 */
public class MyLinkedList<T> implements MyList<T> {
	private Node<T> first = null;
	private Node<T> last = null;
	private int size = 0;
	
	/**
	 * Returns an iterator for this list.
	 *
	 *@return an iterator over the elements in this list. 
	 */
	@Override
	public Iterator<T> iterator() {
		return new MyIterator();
	}

	/**
	 *Checks whether the list is empty.
	 *
	 *@return true if the list contains no elements, false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 *Adds an element to the beginning of the list.
	 *
	 *@param element the element to add.
	 */
	@Override
	public void addFirst(T element) {
		Node<T> node = new Node<T>(element);

        node.setNext(first);
        first = node;

        if (last == null)
            last = node;

        size++;
	}

	/**
	 * Adds an element to the end of the list.
	 * 
	 * @param element the element to add.
	 *
	 */
	@Override
	public void addLast(T element) {
		Node<T> node = new Node<T>(element);
        node.setNext(null);

        if (last != null)
            last.setNext(node);

        last = node;

        if (first == null)
            first = node;

        size++;
	}

	/**
	 *Removes the first occurence of the specified element from the list.
	 *
	 *this method uses a custom iterator to locate and remove the element.
	 *
	 *@param element the element to remove.
	 *@return true if the element was found and removed, false otherwise.
	 */
	@Override
	public boolean remove(T element) {
		 Iterator<T> iter = iterator();

         while (iter.hasNext()) {
             if (iter.next().equals(element)) {
                 iter.remove();
                 return true;
             }
         }

         return false;
	}

    /**
     * Custom iterator implementation for MyLinkedList.
     * 
     * Tracks the current and previous nodes and enforces correct remove() usage.
     * 
     */
    private class MyIterator implements Iterator<T> {
        private Node<T> current;
        private Node<T> previous;
        private boolean canRemove;

        /**
         * Constructs a new iterator starting before the first element.
         * 
         */
        public MyIterator() {
            Node<T> node = new Node<T>(null);
            node.setNext(first);

            current = node;
            previous = node;
            canRemove = false;
        }

		/**
		 *Checks if there is another element in the list.
		 *
		 *@return true if another element exists, false otherwise.
		 */
		@Override
		public boolean hasNext() {
			return current.getNext() != null;
		}

		/**
		 *Returns the next element in the iteration.
		 *
		 *@return the next element
		 *@throws NoSuchElementException if no more elements exist.
		 */
		@Override
		public T next() {
			if (!hasNext())
                throw new NoSuchElementException();

            previous = current;
            current = current.getNext();
            canRemove = true;

            return current.getValue();
		}

		/**
		 *Removes the last element returned by next().
		 *
		 *This method can only be called once per call to next().
		 *
		 *@throws IllegalStateException if next() has not been called or remove() was already called
		 */
		@Override
		public void remove() {
			if (! canRemove)
                throw new IllegalStateException();

            if (first == current)
                first = current.getNext();

            if (last == current) {
                if (first == null)
                    last = null;
                else
                    last = previous;
            }

            previous.setNext(current.getNext());
            current = previous;
            canRemove = false;
            size--;
		}
    }
}