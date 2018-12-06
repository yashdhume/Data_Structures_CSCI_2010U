package Assignment2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class GapSort {
    public static void swap(int[] arr, int a, int b) {//swap
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    //Gap sort sorts pairs of elements that are far from eacher
    private static void sort(int[] arr){
        int gap= arr.length;
        while(gap>0){//loop untill gap is 0
            gap= (int)(gap/1.03);// gap is 1.03
            for(int i=0; i<=arr.length-1-gap;i++){
                if(arr[i]>arr[i+gap]){
                    swap(arr, i, i+gap);
                }
            }
        }

    }

    private static void printArray(int arr[]) {
        int size = arr.length;
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    private static void check(int size, int tries){//Driver
       // int size = 100000;
        int count =0;
        int[] arr = new int[size];
        Random rnd = new Random();
        ArrayList<Integer> arrCheck = new ArrayList<>();
        ArrayList<Double> avg = new ArrayList<>();
        int tryy= tries;
        while(tries>0) {
            arrCheck.clear();
            for (int i = 0; i < size; i++) {
                int r = rnd.nextInt(size);
                arrCheck.add( r);
                arr[i] = r;

            }
            Collections.sort(arrCheck);
            double startTime, endTime;
            startTime = System.nanoTime();
            sort(arr);// Change this
            endTime = System.nanoTime();
            double time = ((endTime-startTime)/1000000d);
            avg.add(time);

            for(int i =0; i<size; i++){
                if(arr[i] != arrCheck.get(i)){
                    System.out.println("Error");
                    for (int j: arr) System.out.print (j+ " ");
                    System.out.println();
                    for(int j: arrCheck) System.out.print (j+ " ");
                    break;
                }
            }

            System.out.print ("No errors in test case "+ ++count);

            System.out.println(" ("+ +((endTime-startTime)/1000000d)+" milliseconds)");
            tries--;
        }
        double sum = 0;
        if(!avg.isEmpty()) {
            for (double i: avg) {
                sum += i;
            }
            double finalTime = (sum / avg.size());
            System.out.println( "Average Time of "+ tryy +" test cases with size of  "+size+" random numbers for Gap sort: (" + finalTime+" milliseconds) ");
            System.out.println("Sorted array of last test case is ");
            //printArray(arr);//uncomment if array needs to be seen
        }



    }


    public static void main(String args[]) {
        int sizeOfArray =10000;
        int numberOfTestCases = 100;
        check(sizeOfArray, numberOfTestCases);

    }
}