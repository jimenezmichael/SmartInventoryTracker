public class Item {
    private String itemName = null;
    private double itemPrice = 0;
    private String itemType = null;
    private int itemQuantity = 0;

    public Item (String name, double price, String type, int quantity) {
        itemName = name;
        itemPrice = price;
        itemType = type;
        itemQuantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getItemType() {
        return itemType;
    }
    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemName(String name) {
        itemName = name;
    }

    public void setItemPrice(double price) {
        itemPrice = price;
    }

    public void setItemType(String type) {
        itemType = type;
    }

    public void setItemQuantity(int quantity) {
        itemQuantity = quantity;
    }

}
