public class Node {
    public Item data;
    public int intData;
    public Node prev;
    public Node next;

    public Node() {
        this.data = new Item();
        next = null;
        prev = null;
    }

    public Node(Item data) {
        this.data = data;
        next = null;
        prev = null;
    }

    public Node(int intData) {
        this.intData = intData;
        next = null;
        prev = null;
    }
}
