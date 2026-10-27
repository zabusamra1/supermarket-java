package edu.collin.cosc2436.team4.genericsmartshelf;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Demo program that tests the SmartShelf implementation.
 * @author Josh Fletcher, Josiah English, Zaid N.M. Abusamra
 */
public class SmartShelfDemo {
	public static void main(String[] args) {
		// Import Resources
		ArrayList<Cereal> cerealItems = new ArrayList<>();
		ArrayList<Chips> chipsItems = new ArrayList<>();
		
		Scanner cerealScanner = new Scanner (SmartShelfDemo.class.getResourceAsStream("/cereal.txt"));
		Scanner chipsScanner = new Scanner (SmartShelfDemo.class.getResourceAsStream("/chips.txt"));
		
		while (cerealScanner.hasNext()) {
			cerealItems.add(new Cereal(cerealScanner.nextLine()));
		}
		
		while (chipsScanner.hasNext()) {
			chipsItems.add(new Chips(chipsScanner.nextLine()));
		}
		
		cerealScanner.close();
		chipsScanner.close();
		
		// Main Functionality
		SmartShelf<Cereal> cerealShelf = new SmartShelf<Cereal>("Cereal Shelf", "cereal");
		SmartShelf<Chips> chipsShelf = new SmartShelf<Chips>("Chip Shelf", "chips");
		
		Employee employee = new Employee("Jack");
		Customer customerMary = new Customer("Mary");
		Customer customerJohn = new Customer("John");
		
		employee.placeItems(cerealShelf, cerealItems);
		System.out.println();
        System.out.println(cerealShelf);

		employee.placeItems(chipsShelf, chipsItems);
		System.out.println();
        System.out.println(chipsShelf);

        
        customerMary.takeItem(cerealShelf, "Apple Jacks", RetailItemType.CEREAL);
        customerMary.takeItem(cerealShelf, "Cinnamon Toast Crunch", RetailItemType.CEREAL);
        customerMary.takeItem(cerealShelf, "Cinnamon Toast Crunch", RetailItemType.CEREAL);
        
        customerJohn.takeItem(chipsShelf, "Lays", RetailItemType.CHIPS);
        customerJohn.takeItem(chipsShelf, "Bugles", RetailItemType.CHIPS);
        
        employee.addItem(cerealShelf, new Cereal("Cinnamon Toast Crunch"));
        employee.addItem(cerealShelf, new Cereal("Lucky Charms"));

        System.out.println();
        System.out.println(cerealShelf);
        
        employee.addItem(chipsShelf, new Chips("Ruffles"));
        employee.addItem(chipsShelf, new Chips("Bugles"));
        
        System.out.println();
        System.out.println(chipsShelf);
    }
}


