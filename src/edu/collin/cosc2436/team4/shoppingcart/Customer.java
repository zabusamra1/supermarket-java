package edu.collin.cosc2436.team4.shoppingcart;

import java.util.Iterator;

import edu.collin.cosc2436.team4.genericsmartshelf.IShelfCustomer;
import edu.collin.cosc2436.team4.genericsmartshelf.RetailItem;
import edu.collin.cosc2436.team4.genericsmartshelf.RetailItemType;
import edu.collin.cosc2436.team4.shoppinglist.MyList;
import edu.collin.cosc2436.team4.shoppinglist.ShoppingListEntry;
import edu.collin.cosc2436.team4.smartshelf.OutOfStockException;

/**
 * Represents a supermarket customer interacting with
 * a smart shelf.
 * 
 * Customer interacts with shelves using a custom linked list of ShoppingListEntry
 * objects and removes items when successfully purchased.
 */
public class Customer {
	private final String name;
	private Supermarket market;
	private ShoppingCart cart;
	
	/**
	 * Constructor constructs a customer with the specified name.
	 * @param name The name of the customer
	 */
	public Customer(String name) {
		this.name = name;
	}
	
	/**
	 * @return the cart
	 */
	public ShoppingCart getCart() {
		return cart;
	}

	/**
	 * @param cart the cart to set
	 */
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	/**
	 * @return the market
	 */
	public Supermarket getMarket() {
		return market;
	}

	/**
	 * @param market the market to set
	 */
	public void setMarket(Supermarket market) {
		this.market = market;
	}

	/**
	 * Attempts to retrieve an item from the shelf.
	 * Method prints messages indicating the attempt and success of retrieving the item.
	 * if the item is not available, an exception is thrown.
	 * @param <M> the type of RetailItem stored on the shelf.
	 * @param shelf The shelf from which the item will be retrieved.
	 * @param itemToGet the name of the item to retrieve.
	 * @param type the type/category of the item.
	 * @throws OutOfStockException if the requested item is not available on the shelf.
	 */
	private <M extends RetailItem> void takeItem(IShelfCustomer<M> shelf, String itemToGet, RetailItemType type) throws OutOfStockException {
		System.out.println(getName() + " getting from " + shelf.getName()  + ": " + itemToGet);

        RetailItem item = shelf.findAndTake(itemToGet, type);

        System.out.println(getName() + " got " + item.getName());
	}

    /**Prints the shopping list before shopping using an enhanced for loop
     * Iterates through the list using a custom iterator.
     * Attempts to retrieve each item from its corresponding shelf.
     * Removes succesfully retrieved items from the list.
     * keeps items on the list if they are out of stock.
     * prints final result after shopping.
     * @param list The shopping list containing ShoppingListEntry items
     * implemented using a custom List
     * 
     * @param market The supermarket containing shelves to retrieve items from.
     */
    public void shop(MyList<ShoppingListEntry> list,  Supermarket market) {
        System.out.println(getName() + " needs to buy:");

        for (ShoppingListEntry entry : list) {
            System.out.println(entry);
        }
        
        System.out.println(getName() + " is taking a cart from the supermarket");
        setCart(market.takeCart());

        Iterator<ShoppingListEntry> iter = list.iterator();

        while (iter.hasNext()) {
            ShoppingListEntry entry = iter.next();
            IShelfCustomer<? extends RetailItem> shelf = market.findShelf(entry.getShelfName());

            try {
                takeItem(shelf, entry.getItemName(), entry.getItemType());
                iter.remove();
            } catch (OutOfStockException e) {
                System.out.println(e);
            }
        }
        if (list.isEmpty()) {
            System.out.println(getName() + " got everything");
        } else {
            System.out.println(getName() + " still has on the list:");
            
            for (ShoppingListEntry entry : list) {
                System.out.println(entry);
            }
        }
    }
    
    /**
     * 
     */
    public void checkout() {
    	market.getCounter().setCustomer(this);
    }
    
    /**
     * @param receipt
     */
    public void takeRecipt(String receipt) {
    	System.out.println(receipt);
    	
        System.out.println(getName() + " is returning shopping cart");
        market.returnCart(cart);
        cart = null;
    }

	/**
	 * Returns Customer name.
	 * @return name The name of the customer.
	 */
	public String getName() {
		return name;
	}
}
