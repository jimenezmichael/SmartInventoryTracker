import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class SmartInventoryTracker {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String userFile = scnr.nextLine();
        FileInputStream inventoryFile = null;
        try {
            inventoryFile = new FileInputStream(userFile);
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not open input file - ending program");
            System.exit(1);
        }

        Scanner reader = new Scanner(inventoryFile);
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            System.out.println(data);
        }
        reader.close();

        PrintWriter writer = new PrintWriter() {

        }

    }

    public static void recommendPurchase (File currentInventory) {
        // method will look at a file and see what items are low in stock
    }

    public static void predictInventory (File inventoryHistory, File currentInventory) {
        // method will look at old inventory and compare to current inventory to warn of possible over/under stocking
    }

    public static void restock () {
        // method will connect to websites and automatically reorder items that are low on inventory
    }

}
