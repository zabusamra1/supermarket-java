package edu.collin.cosc2436.team4.cashregister;

/**
 * @author Josh Fletcher, Zaid Abusamra,Josiah English
 * The CashRegisterDemo class demonstrates the use of the
 * CashRegister system with multiple transactions.
 */
public class CashRegisterDemo {

	 /**
     * Main method
     *
     * @param args Command-line arguments
     */
	public static void main(String[] args) {
		
		 // Prices correspond to enum ordinal values:
        // SOAP, SODA, CHIPS, CEREAL
		double[] prices = {2.49, 3.25, 1.79, 2.99};
		double taxRate = 0.0825;
		
		 // Create the RetailItemLookup object
		RetailItemLookup lookup = new RetailItemLookup(taxRate, prices);
		
		// Set shared lookup for all CashRegister instances
		CashRegister.setRetailItemLookup(lookup);
		
		// Create a CashRegister
		CashRegister register = new CashRegister();
		
		 // Transaction 1: all nontaxable-groceries
		register.startTransaction();
        register.scanItem(RetailItem.CHIPS);
        register.scanItem(RetailItem.CEREAL);
        register.printReceipt();

        // Transaction 2: All taxable
        register.startTransaction();
        register.scanItem(RetailItem.SOAP);
        register.scanItem(RetailItem.SODA);
        register.printReceipt();

        // Transaction 3: Mixed
        register.startTransaction();
        register.scanItem(RetailItem.CHIPS);
        register.scanItem(RetailItem.CEREAL);
        register.scanItem(RetailItem.SOAP);
        register.scanItem(RetailItem.SODA);
        register.printReceipt();

	}

}
