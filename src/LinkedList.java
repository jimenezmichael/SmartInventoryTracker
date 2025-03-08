public class LinkedList {
    public Node head;
    public Node tail;
    private int size;

    public LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public LinkedList(LinkedList list) {
        head = list.head;
        tail = list.tail;
        size = list.size;
    }

    public void addNode(Item item) {
        if (head == null) {
            Node n = new Node(item);
            head = n;
            tail = n;
        }
        else {
            Node n = new Node(item);
            n.prev = tail;
            tail.next = n;
            tail = n;
        }
    }

    public void addNode(int quantity) {
        if (head == null) {
            Node n = new Node(quantity);
            head = n;
            tail = n;
        }
        else {
            Node n = new Node(quantity);
            n.prev = tail;
            tail.next = n;
            tail = n;
        }
    }

    public void printIntList() {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.intData + ", ");
            curr = curr.next;
        }
        System.out.println();
    }

    public int getSize() {
        int count = 0;
        Node curr = head;
        while (curr.next != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}
