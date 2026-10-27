package edu.collin.cosc2436.team4.smartshelf;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Demo program that tests the SmartShelf implementation.
 * @author Josh Fletcher, Josiah English, Zaid N.M. Abusamra
 */
public class SmartShelfDemo {
	
	public static void main(String[] args) {
		
		SmartShelf shelf = new SmartShelf("Cereal Shelf");
		Employee employee = new Employee();
		Customer customer = new Customer();
		
		ArrayList<RetailItem> cerealItems = new ArrayList<>();
		
		Scanner scanner = new Scanner (SmartShelfDemo.class.getResourceAsStream("/cereal.txt"));
		
		while (scanner.hasNext()) {
			cerealItems.add(new RetailItem(scanner.nextLine()));
		}
		scanner.close();
		
		employee.placeItems(shelf, cerealItems);
        
        customer.getItem(shelf, "Apple Jacks");
        customer.getItem(shelf, "Cinnamon Toast Crunch");
        customer.getItem(shelf, "Cinnamon Toast Crunch");
        
        employee.addItem(shelf, new RetailItem("Cinnamon Toast Crunch"));
        employee.addItem(shelf, new RetailItem("Lucky Charms"));

        System.out.println();
        System.out.println(shelf);
    }
	}


