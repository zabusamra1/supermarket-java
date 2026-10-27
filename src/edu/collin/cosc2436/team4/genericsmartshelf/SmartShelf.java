package edu.collin.cosc2436.team4.genericsmartshelf;

import java.util.ArrayList;
import java.util.List;

import edu.collin.cosc2436.team4.smartshelf.OutOfStockException;

/**
 * A smart shelf that stores retail items alphabetically
 *  and supports operations for customers and employees.
 */
public class SmartShelf<T extends RetailItem> implements IShelfCustomer<T>, IShelfEmployee<T> {
	private final String contentsType;
	private final String name;
	private final ArrayList<T> items;
	
	/**
	 * Constructs a new SmartShelf.
	 * 
	 * @param contentsType of the shelf type
	 */
	public SmartShelf(String name, String contentsType) {
		this.name = name;
		this.contentsType = contentsType;
		items = new ArrayList<>();
	}
	
	/**
	 *Places unsorted items on the shelf and sorts them.
	 */
	@Override
	public void placeItems(List<T> newItems) {
		items.addAll(newItems);
		
		quickSort(items, 0, items.size()-1);
	}
	
	/**
	 * QuickSort algorithm implementation
	 * @param arr The ArrayList to sort
	 * @param start The starting point for the partition
	 * @param end The ending point for the partition
	 */
	private static <M extends RetailItem> void quickSort(ArrayList<M> arr, int start, int end) {
		
		if(start < end) {
			int pos = partition(arr, start, end);
			
			quickSort(arr, start, pos-1);
			quickSort(arr, pos+1, end);
		}
	}
	
	/**
	 * Partition algorithm used by Quicksort.
	 * @param arr The ArrayList to sort
	 * @param start The starting point for the partition
	 * @param end The ending point for the partition
	 * @return The index of the pivot after it has been put in it's final sorted position
	 */
	private static <M extends RetailItem> int partition(ArrayList<M> arr, int start, int end) {
		
		M pivot = arr.get(end);
		
		int pos = start;
		
		for(int i = start; i< end; i++) {
			if(arr.get(i).compareTo(pivot)<=0) {
				swap(arr, pos++, i);
			}
		}
		swap(arr, pos, end);
		
		return pos;
	}
	
	/**
	 * Swaps two elements in the list.
	 * @param arr The ArrayList to swap items in
	 * @param i The first item to swap
	 * @param j The second item to swap
	 */
	private static <M extends RetailItem> void swap(ArrayList<M> arr, int i, int j) {
		
		M tmp = arr.get(i);
		arr.set(i,  arr.get(j));
		arr.set(j, tmp);
	}
	
	/**
	 * Adds a new item while maintaining sorted order.
	 */
	@Override
	public void addItem(T item) {
		
		int pos = searchItems(items, item);
		
		items.add(pos, item);
		}
	
	/**
	 * Modified binary search to find insertion position. This method does not prevent the insertion point from
	 * going beyond the upper bound of the ArrayList
	 * @param items The ArrayList to search
	 * @param target The item to search for
	 * @return Either the item or the place it should be if it existed. This may be equal to the size of the ArrayList.
	 */
	private static <M extends RetailItem> int searchItems(ArrayList<M> items, RetailItem target) {
		
		int lo = 0;
		int hi = items.size() - 1;
		
		if(items.size()==0)
			return 0;
		
		while(lo<=hi) {
			
			int mid = lo + (hi-lo) / 2;
			
			int cmp = target.compareTo(items.get(mid));
			
			if(cmp > 0 )
				lo = mid + 1;
			else
				hi = mid - 1;
		}
		return lo;
	}
	
	/**
	 * Finds and removes an item from the shelf.
	 */
	@Override
	public T findAndTake(String name, RetailItemType type) throws OutOfStockException{
		
		RetailItem tmp = new RetailItem(name, type);
		
		int pos = searchItems(items, tmp);
		
		if(pos < items.size() && items.get(pos).getName().compareTo(name)==0)
			return items.remove(pos);
		
		throw new OutOfStockException(name);
	}
	
	/**
	 *Returns a list of items on the shelf.
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(getName()).append(":\n");
		
		for(RetailItem item : items)
			builder.append("\t").append(item.getName()).append("\n");
		
		return builder.toString();
	}

	/**
	 * getter for ContentsType.
	 * @return ContentsType
	 */
	public String getContentsType() {
		return contentsType;
	}

	/**
	 * @return name The name of this shelf
	 */
	@Override
	public String getName() {
		return name;
	}
}


