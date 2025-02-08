import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;

// this class represents a check of inventory and is meant to update quantities of Items
public class InventoryCheck {
    String date;
    ArrayList<String> quantities;

    public InventoryCheck () {
        date = "1/1/2000";
        quantities = null;
    }

    public InventoryCheck (String newDate, ArrayList<String> args) {
        date = newDate;
        quantities = args;
    }

    public ArrayList<String> getQuantities() {
        return quantities;
    }
}
