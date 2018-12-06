package Labs.Lab4;
import java.util.Random;

public class LinkedListDriver {
    public static void main(String[] args) {
        LinkedList<Warrior> list = new SortedDoublyLinkedList<>();
        System.out.println(list);
        Warrior krogg = new Warrior("Krogg", 30, 50, 200);
        list.insert(krogg);
        System.out.println(list);
        Warrior gurkh = new Warrior("Gurkh", 40, 45, 180);
        list.insert(gurkh);
        System.out.println(list);
        Warrior brynn = new Warrior("Brynn", 45, 40, 190);
        list.insert(brynn);
        System.out.println(list);
        Warrior dolf = new Warrior("Dolf", 20, 65, 210);
        list.insert(dolf);
        System.out.println(list);
        Warrior zuni = new Warrior("Zuni", 50, 35, 170);
        list.insert(zuni);
        System.out.println(list);

        System.out.println();

        LinkedList<String> stringTest = new SortedDoublyLinkedList<>();
        stringTest.insert("Hello");
        stringTest.insert(" ");
        stringTest.insert("World");
        stringTest.insert("!");
        System.out.println(stringTest);

        LinkedList<Integer> intTest = new SortedDoublyLinkedList<>();
        Random rnd = new Random();
        for(int i = 0; i <10000; i++) intTest.insert(rnd.nextInt(10001));
        //System.out.println(a);
        System.out.println(intTest);



    }
}
