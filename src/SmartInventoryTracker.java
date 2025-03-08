import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class SmartInventoryTracker {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("==========Welcome to Smart Inventory Tracker==========");
        System.out.println();

        ArrayList<Item> allItems = new ArrayList<>();

        // reads from file and creates new items based off of each line in a file
        FileInputStream myFile = null;
        try {
            myFile = new FileInputStream("/Users/michaeljimenez/Library/CloudStorage/OneDrive-Personal/Documents/2024-2025/CSC 112/SmartInventoryTracker/src/Syrups.txt");
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not open input file – ending program");
            System.exit(1);
        }

        Scanner fileReader = new Scanner(myFile); //set the scanner to read from a file
        String header = fileReader.nextLine(); // read header
        while (fileReader.hasNextLine()) {
            String data = fileReader.nextLine();
            String[] arrOfData = data.split(",");
            String itemName = arrOfData[0]; //first element is name of item
            Item item = new Item();
            item.setName(itemName);

            // for loop reads each quantity value and adds as a node to LinkedList
            for (int i = 1; i < arrOfData.length; i++) {
                try {
                    int quantity = Integer.parseInt(arrOfData[i]);
                    item.quantityHistory.addNode(quantity);

                    if (i == arrOfData.length - 1) {
                        item.setCurrentQuantity(quantity);
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid number");
                    System.exit(1);
                }
            }
            allItems.add(item); // adds new item to ArrayList
        }
        fileReader.close(); //closes the stream’s connection to a file

        // checks each item to make sure all variables have been defined
        for(int i = 0; i < allItems.size(); i++) {
            System.out.println("Checking for issues with Item: " + allItems.get(i).getName());
            if(allItems.get(i).getPrice() == 0) {
                System.out.println("Price has not been set, set it now.");
                allItems.get(i).setPrice(scnr.nextDouble());
            }
            if(allItems.get(i).getType() == null) {
                System.out.println("Type has not been set, set it now.");
                allItems.get(i).setType(scnr.next());
            }
            if(allItems.get(i).getCriticalStock() == 0) {
                System.out.println("Critical stock has not been set, set it now.");
                allItems.get(i).setCriticalStock(scnr.nextInt());
            }

            System.out.println("All issues resolved");
        }


        // while loop runs as long as user wants to keep performing tasks
        String nextTask = "z";
        while(!nextTask.equalsIgnoreCase("q")) {
            // prints options
            System.out.println("What would you like to do?");
            System.out.println("Add a new item ('a')");
            System.out.println("See total inventory ('t')");
            System.out.println("Start a new inventory check ('c')");
            System.out.println("See purchase recommendations ('r')");

            // executes chosen option
            nextTask = scnr.next();
            if(nextTask.equalsIgnoreCase("a")) {
                allItems.add(addItem());
                // sets all previous quantities of new item to 0 since it never existed
                for(int i = 0; i < allItems.get(0).quantityHistory.getSize(); i++) {
                    allItems.get(allItems.size() - 1).quantityHistory.addNode(0);
                }
                int temp = allItems.getLast().getCurrentQuantity();
                allItems.getLast().quantityHistory.tail.intData = temp;
                allItems.getLast().quantityHistory.head.intData = 0;
            }

            if(nextTask.equalsIgnoreCase("t")) {
                printInventory(allItems);
            }

            if(nextTask.equalsIgnoreCase("c")) {
                inventoryCheck(allItems);
            }
            if(nextTask.equalsIgnoreCase("r")) {
                recommendPurchase(allItems);
            }

        }


    }

    // prompts user for each variable of their new item
    public static Item addItem() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("What is your new item?");
        String itemName = scnr.nextLine();
        System.out.println("How much does " + itemName + " cost?");
        double itemPrice = scnr.nextDouble();
        System.out.println("What kind of item is " + itemName + " ?");
        String itemType = scnr.next();
        System.out.println("How many units of " + itemName + " do you currently have?");
        int itemQuantity = scnr.nextInt();
        System.out.println("How many units of " + itemName + " are needed at all times?");
        int itemCriticalStock = scnr.nextInt();
        Item i = new Item(itemName, itemPrice, itemType, itemQuantity, itemCriticalStock);
        return i;
    }

    // updates the tail of each item in the list
    public static void inventoryCheck(ArrayList<Item> list) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Starting new inventory check...");
        System.out.println();
        for(int i = 0; i < list.size(); i++) {
            System.out.println("How many units of " + list.get(i).getName() + " do you currently have?");
            list.get(i).quantityHistory.addNode(scnr.nextInt());
            list.get(i).setCurrentQuantity(list.get(i).quantityHistory.tail.intData);
        }
    }

    // prints name and quantity history
    public static void printInventory(ArrayList<Item> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).getName() + ", ");
            list.get(i).quantityHistory.printIntList();
        }
    }

    // compares critical quantity to current quantity to make a recommended purchase
    public static void recommendPurchase (ArrayList<Item> list) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getCurrentQuantity() < list.get(i).getCriticalStock()) {
                System.out.println(list.get(i).getName() + " is low in units, purchase recommended");
            }
            else {
                System.out.println(list.get(i).getName() + " is sufficiently stocked");
            }
        }
    }

    public static void predictInventory (File inventoryHistory, File currentInventory) {
        // method will look at old inventory and compare to current inventory to warn of possible over/under stocking
    }

    public static void restock () {
        // method will connect to websites and automatically reorder items that are low on inventory
    }

}
