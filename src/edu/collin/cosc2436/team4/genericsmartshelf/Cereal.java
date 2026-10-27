package edu.collin.cosc2436.team4.genericsmartshelf;

/**
 * A Cereal box
 */
public class Cereal extends RetailItem {

	/**
	 * @param name The name of the type of cereal
	 */
	public Cereal(String name) {
		super(name, RetailItemType.CEREAL);
	}
}
