package Labs.Lab7;


public class Main {
    public static void main (String[] args){
        String[] origNumbers = {"0011", "1001", "1000", "0111", "0101"};
        RadixSort rs = new RadixSort();
        for(String i:origNumbers){
            rs.numbers.add(i);
        }
        rs.radixSort();
    }
}
