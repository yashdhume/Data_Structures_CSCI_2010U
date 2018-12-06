package Labs.Lab4;

public class SortedDoublyLinkedList<T extends Comparable<T>> implements LinkedList<T> {
    public class Node{
        public Node previous;
        public Node next;
        public  T type;

        public Node(T type){ this.type = type;}
        public T getType() { return type; }
        public Node getNext() { return next; }
        public String toString() { return type.toString(); }

    }
    private Node head;
    private int count;
    private Comparable<T> c;
    public SortedDoublyLinkedList() {
        this(null);
    }

    public SortedDoublyLinkedList(Comparable<T> c) {
        this.head = null;
        this.count = 0;
        this.c = c;
    }

    @Override
    public void insert(T type) {
        Node newNode = new Node(type);
        Node previousNode = null;
        if (this.count == 0) this.head = newNode;
        else {
            boolean isThere = false;
            Node node = this.head;
            while (!isThere && node != null) {
                int r = type.compareTo(node.getType());
                if (r >= 0) {
                    if (node.previous == null) this.head = newNode;
                    else{
                        newNode.previous=node.previous;
                        node.previous.next = newNode;
                    }
                    node.previous = newNode;
                    newNode.next = node;
                    isThere = true;
                }
                if (node.next == null) previousNode = node;
                node = node.next;
            }
            if (!isThere) {
                previousNode.next = newNode;
                newNode.previous = previousNode;
            }
        }
        this.count++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        if (this.count > 0) {
            Node node = this.head;
            while (node != null) {
                sb.append(node + " ");
                node = node.getNext();
            }
        }
        sb.append(']');
        return sb.toString();

    }
}