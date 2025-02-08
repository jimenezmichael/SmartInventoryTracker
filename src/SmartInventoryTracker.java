import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class SmartInventoryTracker {
    public static void main(String[] args) {

        FileInputStream inventoryFile = null;
        String fileName = null;
        try {
            inventoryFile = new FileInputStream(args[0]);
            fileName = args[0];
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not open " + args[0] + " - ending program");
            System.exit(1);
        }

        TotalInventory inventory = new TotalInventory();

        Scanner reader = new Scanner(inventoryFile);
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            System.out.println(data);

            String[] arrOfData = data.split(",");
        }
        reader.close();

        Item newItem = new Item("Chocolate", 6.95, "syrup", 0);


        FileOutputStream myFile = null;

        try {
            myFile = new FileOutputStream(fileName, true);

        }
        catch(FileNotFoundException e) {
            System.out.println("File could not be opened for output - closing file");
            System.exit(1);
        }

        PrintWriter writer = new PrintWriter(myFile);
        writer.println(newItem.getItemName() + "," + newItem.getItemQuantity());
        writer.flush();
        writer.close();



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
