package Assignment2;

import java.util.ArrayList;

public class KSort {
    private static ArrayList <Integer> heap;
    private static int k;
    KSort(int[] arr, int k){
        heap= new ArrayList<>(k+1);
        this.k =k;
        for(int i =0; i<=k&&i<arr.length; i++){
            heap.add(arr[i]);
        }
    }
    public void PrintHeap(){
        System.out.println(heap);
    }
    public void printArray(int []arr){ for(int i :arr) System.out.print(i+ " "); }

    public static void GenerateHeap(){
        int size = heap.size();
        for(int i =heap.size()/2-1;i>=0;i--){
            SiftDown(i, size);
        }
    }
    public static void SiftDown(int x, int size){
        int last = x;
        int right = 2*x+2;
        int left = 2*x+1;
        if(right< size && heap.get(right) <heap.get(last)) last = right;
        if(left<size && heap.get(left) < heap.get(last)) last = left;
        if (last!=x){
            int swap = heap.get(x);
            heap.set(x, heap.get(last));
            heap.set(last, swap);
            SiftDown(last, size);
        }
    }
    public static void sortK(int arr[]){
        GenerateHeap();
        int count=0;
        for(int i=k+1;i<arr.length;i++){
            arr[count++] = getRemMin();
            heap.add(arr[i]);
            GenerateHeap();
        }
        while(!(heap.size()==0))arr[count++] = getRemMin();
    }
    public static int getRemMin(){
        int a =heap.get(0);
        heap.remove(0);
        GenerateHeap();
        return a;
    }
    public static void main(String[] args){
        int [] arr = {6,5,3,2,8, 10,9};
        int k =3;
        KSort ks = new KSort(arr, k);
        ks.sortK(arr);
        ks.printArray(arr);
    }

}
