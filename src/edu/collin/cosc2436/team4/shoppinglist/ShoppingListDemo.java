package edu.collin.cosc2436.team4.shoppinglist;

import edu.collin.cosc2436.team4.genericsmartshelf.Cereal;
import edu.collin.cosc2436.team4.genericsmartshelf.Chips;
import edu.collin.cosc2436.team4.genericsmartshelf.Employee;
import edu.collin.cosc2436.team4.genericsmartshelf.RetailItem;
import edu.collin.cosc2436.team4.genericsmartshelf.RetailItemType;
import edu.collin.cosc2436.team4.genericsmartshelf.SmartShelf;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Josh Fletcher, Josiah English, Zaid N.M. Abusamra.
 * 
 * Runs the shopping list simulation.
 * 
 */
public class ShoppingListDemo {

   
    public static void main(String[] args) {
        Supermarket market = new Supermarket();

        SmartShelf<Cereal> cerealShelf = new SmartShelf<>("Cereal Shelf", "cereal");
        SmartShelf<Chips> chipsShelf = new SmartShelf<>("Chips Shelf", "chips");
        SmartShelf<RetailItem> sodaShelf = new SmartShelf<>("Soda Shelf", "soda");
        SmartShelf<RetailItem> soapShelf = new SmartShelf<>("Soap Shelf", "soap");

        market.addShelf(cerealShelf);
        market.addShelf(chipsShelf);
        market.addShelf(sodaShelf);
        market.addShelf(soapShelf);

        ArrayList<Cereal> cereals = loadCereals();
        ArrayList<Chips> chips = loadChips();
        ArrayList<RetailItem> sodas = loadRetailItems("/soda.txt", RetailItemType.SODA);
        ArrayList<RetailItem> soaps = loadRetailItems("/soap.txt", RetailItemType.SOAP);

        Employee employee = new Employee("Jack");
        employee.placeItems(cerealShelf, cereals);
        employee.placeItems(chipsShelf, chips);
        employee.placeItems(sodaShelf, sodas);
        employee.placeItems(soapShelf, soaps);

        Customer john = new Customer("John");
        Customer mary = new Customer("Mary");
        Customer jarJar = new Customer("Jar Jar Binks");

        MyLinkedList<ShoppingListEntry> johnList = new MyLinkedList<>();
        johnList.addLast(new ShoppingListEntry("Coca-Cola", RetailItemType.SODA, "Soda Shelf"));
        johnList.addLast(new ShoppingListEntry("Dial", RetailItemType.SOAP, "Soap Shelf"));
        johnList.addLast(new ShoppingListEntry("Fritos", RetailItemType.CHIPS, "Chips Shelf"));
        johnList.addLast(new ShoppingListEntry("Doritos", RetailItemType.CHIPS, "Chips Shelf"));
        johnList.addLast(new ShoppingListEntry("Apple Jacks", RetailItemType.CEREAL, "Cereal Shelf"));

        MyLinkedList<ShoppingListEntry> maryList = new MyLinkedList<>();
        maryList.addLast(new ShoppingListEntry("Coca-Cola", RetailItemType.SODA, "Soda Shelf"));
        maryList.addLast(new ShoppingListEntry("Neutrogena", RetailItemType.SOAP, "Soap Shelf"));
        maryList.addLast(new ShoppingListEntry("Doritos", RetailItemType.CHIPS, "Chips Shelf"));
        maryList.addLast(new ShoppingListEntry("Apple Jacks", RetailItemType.CEREAL, "Cereal Shelf"));

        MyLinkedList<ShoppingListEntry> jarJarList = new MyLinkedList<>();
        jarJarList.addLast(new ShoppingListEntry("Cheetos", RetailItemType.CHIPS, "Soda Shelf"));
        jarJarList.addLast(new ShoppingListEntry("Red Bull", RetailItemType.SODA, "Soap Shelf"));
        jarJarList.addLast(new ShoppingListEntry("Coke Zero", RetailItemType.SODA, "Chips Shelf"));
        jarJarList.addLast(new ShoppingListEntry("Ivory", RetailItemType.SOAP, "Cereal Shelf"));

        john.shop(johnList, market);
        System.out.println();
        mary.shop(maryList, market);
        System.out.println();
        jarJar.shop(jarJarList, market);
    }

  
    /**
     * Loads cereal items from a resource file and converts them into Cereal Objects.
     * Each line in the file represents a cereal name.
     * @return an ArrayList containing all loaded Cereal items.
     */
    private static ArrayList<Cereal> loadCereals() {
        ArrayList<Cereal> items = new ArrayList<>();
        try (Scanner scanner = new Scanner(ShoppingListDemo.class.getResourceAsStream("/cereal.txt"))) {
            while (scanner.hasNextLine()) {
                items.add(new Cereal(scanner.nextLine()));
            }
        }
        return items;
    }

    
    /**
     * Loads chip items from a resource file and converts them into Chip objects.
     * Each line in the file represents a chip name.
     * @return an ArrayList containing all loaded Chip items.
     */
    private static ArrayList<Chips> loadChips() {
        ArrayList<Chips> items = new ArrayList<>();
        try (Scanner scanner = new Scanner(ShoppingListDemo.class.getResourceAsStream("/chips.txt"))) {
            while (scanner.hasNextLine()) {
                items.add(new Chips(scanner.nextLine()));
            }
        }
        return items;
    }

    
    /**
     * loads generic retail items from a resource file and assigns them a type.
     * Each line in the file represents an item name.
     * @param resourcePath Path to the resource file containing item names.
     * @param type the type of retail item to create.
     * @return an ArrayList of RetailItem objects.
     */
    private static ArrayList<RetailItem> loadRetailItems(String resourcePath, RetailItemType type) {
        ArrayList<RetailItem> items = new ArrayList<>();
        try (Scanner scanner = new Scanner(ShoppingListDemo.class.getResourceAsStream(resourcePath))) {
            while (scanner.hasNextLine()) {
                items.add(new RetailItem(scanner.nextLine(), type));
            }
        }
        return items;
    }
}

