package Assignment2;

public class KSortOnk {
    public static void kSort(int arr[], int k){
        int n= arr.length;
        for (int i=1; i<n; i++){
            int key= arr[i];
            int j;
            for(j=i; j>0 &&j>i-k && arr[j-1]>key; j--) arr[j]= arr[j-1];//sorts the first elements
            arr[j]=key;
        }

    }
    public static void printArray(int arr[]){
        for(int i : arr) System.out.print(i+" ");
    }
    public static void main(String[] args){
        int [] arr = {6,5,3,2,8, 10,9};
        int [] arr2= {10, 9,8,7,4, 70, 60, 40};
        kSort(arr, 3);
        printArray(arr);
        System.out.println();
        kSort(arr2, 4);
        printArray(arr2);
    }
}
