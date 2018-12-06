package Labs.Lab7;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {
    public Buckets buck;
    public List<String> numbers;
    public RadixSort(){
        numbers = new ArrayList<>();
        buck = new Buckets();
    }
    public void radixSort() {
        int numDigits = numbers.get(0).length();
        //int numDigits = 4;
        for (int i = 0; i < numDigits; i++) {
            print(numbers);
            for (String j: numbers) {
                if (j.charAt(numDigits - 1 - i) == '0') buck.addZero(j);
                else  buck.addOne(j);
            }
            numbers = buck.getAllInOrder();
            for (String j : numbers) {
                if (j.charAt(numDigits - 1 - i) == '0') buck.removeZero(j);
                else buck.removeOne(j);
            }
        }
        print(numbers);
    }
    public static void print(List<String> numbers){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (String i :numbers){
            sb.append(i+ " ");
        }
        sb.append(" ]");
        System.out.println( sb.toString());

    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (String i :numbers){
            sb.append(i+ " ");
        }
        sb.append(" ]");
        return sb.toString();
    }
}
