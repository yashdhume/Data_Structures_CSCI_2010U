package Labs.Lab5;


import java.util.ArrayList;
import java.util.Scanner;

public class Priority{
    private static ArrayList <Integer> data;
    public Priority(){
        data = new ArrayList<>();
    }
    public static void ReadData() {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()){
            data.add(scan.nextInt());
        }
    }

    public static void GenerateHeap(){
        int size = data.size();
        for(int i =data.size()/2-1;i>=0;i--){
            SiftDown(i, size);
        }
    }
    public static void SiftDown(int x, int size){
        int last = x;
        int right = 2*x+2;
        int left = 2*x+1;

        if(right< size && data.get(right) >data.get(last)) last = right;
        if(left<size && data.get(left) > data.get(last)) last = left;
        if (!(last==x)){
            int swap = data.get(x);
            data.set(x, data.get(last));
            data.set(last, swap);
            SiftDown(last, size);
        }
    }
    public static void HeapSort(){
        for(int i = data.size()-1; i>=0; i--){
            int temp = data.get(0);
            data.set(0, data.get(i));
            data.set(i, temp);
            SiftDown(0, i);
        }
    }
    public static void insert(int val) {
        data.add(val);
        GenerateHeap();
    }
    public static void printHeap(){
        System.out.println(data);
    }
    public static void Solve(){
        ReadData();
        GenerateHeap();
       // insert(35);
      // HeapSort();
        printHeap();
    }
    public static void main(String[] args){
        Priority p = new Priority();
        //p.GenerateHeap();
        p.Solve();
        //insert(10);
        //p.printHeap();
    }

}