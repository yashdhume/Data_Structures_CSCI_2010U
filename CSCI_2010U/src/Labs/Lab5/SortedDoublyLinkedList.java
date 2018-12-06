package Labs.Lab5;


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
    public int assignmentCount;
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
                    if (node.previous == null) {
                        this.head = newNode;
                        assignmentCount++;
                    }

                    else{
                        newNode.previous=node.previous;
                        node.previous.next = newNode;
                        assignmentCount+=2;
                    }
                    node.previous = newNode;
                    newNode.next = node;
                    isThere = true;
                    assignmentCount+=3;
                }
                if (node.next == null) {
                    previousNode = node;
                    assignmentCount++;
                }
                node = node.next;
                assignmentCount++;
            }
            if (!isThere) {
                previousNode.next = newNode;
                newNode.previous = previousNode;
                assignmentCount+=2;
            }

        }
        this.count++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        if (this.count >0) {
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