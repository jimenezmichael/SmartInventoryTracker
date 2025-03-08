public class Item {
    private String name;
    private double price;
    private String type;
    private int currentQuantity;
    private int criticalStock;
    public LinkedList quantityHistory;

    // default constructor
    public Item() {
        name = null;
        price = 0;
        type = null;
        currentQuantity = 0;
        criticalStock = 0;
        quantityHistory = new LinkedList();
        quantityHistory.addNode(currentQuantity);
    }
    // parameterized constructor
    public Item (String name, double price, String type, int quantity, int criticalStock) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.currentQuantity = quantity;
        this.criticalStock = criticalStock;
        quantityHistory = new LinkedList();
        quantityHistory.addNode(currentQuantity);
    }

    // copy constructor
    public Item(Item i) {
        name = i.name;
        price = i.price;
        type = i.type;
        currentQuantity = i.currentQuantity;
        criticalStock = i.criticalStock;
    }

    // getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public int getCriticalStock()   {
        return criticalStock;
    }

    public LinkedList getQuantityHistory() {
        return new LinkedList(quantityHistory);
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
        quantityHistory.addNode(currentQuantity);
    }

    public void setCriticalStock(int criticalStock) {
        this.criticalStock = criticalStock;
    }

    @Override
    public String toString() {
        return "Item Name: " + name;
    }


}
