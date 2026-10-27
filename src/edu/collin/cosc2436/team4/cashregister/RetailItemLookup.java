package edu.collin.cosc2436.team4.cashregister;

/**
 * The RetailItemLookup class provides prices and tax values
 * for retail items. It is used by the CashRegister class.
 */

public class RetailItemLookup {

	 /** Sales tax rate */
	private final double taxRate;
	
	 /** Array of prices indexed by RetailItem ordinal value */
	private final double[] prices;
	
	 /**
     * Constructor
     *
     * @param rate The sales tax rate
     * @param priceArray The prices for the retail items
     */
	public RetailItemLookup(double rate,double[] pricesArray) {
		taxRate= rate;
		
		 // Copy array elements to prevent security issues
		prices = new double[pricesArray.length];
		for (int i = 0; i < pricesArray.length; i++) {
			prices[i] = pricesArray[i];
			
		}
		
	}	
	
	/**
	 * Returns the price of a retail item.
	 *
	 * @param item The retail item
	 * @return The price of the item
	 */
	public double lookupPrice(RetailItem item) {
		return prices[item.ordinal()];
	}
	
	  /**
     * Computes the tax for a retail item.
     *
     * @param item The retail item
     * @return The tax amount
     */
	public double computeTax(RetailItem item) {
        double price = lookupPrice(item);
        switch (item) {
            case SOAP:
            case SODA:
                return price * taxRate; // Taxable
            case CHIPS:
            case CEREAL:
            default:
                return 0.0;    }
	}
}