package Assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ThreeWayMergeSort {
    public static int getElement(int arr[], int i){
        if(i<arr.length) return arr[i];
        else return Integer.MAX_VALUE;//so it wont go out of bounds
    }
    public static void merge(int[] merge1, int[] merge2, int[] merge3, int[] d) {//merge 3 arrays
        int element1 = getElement(merge1, 0);
        int element2 = getElement(merge2, 0);
        int element3 = getElement(merge3, 0);
        int index1=0, index2=0, index3=0,dIndex = 0;//dIndex is the dimestions of the arrays.
        while (dIndex < d.length) {// loops intil the lenth of the given array aray and the dimention index
            if (element1 <= element2) {
                if (element3 <= element1) {
                    d[dIndex] = element3;
                    element3 = getElement(merge3, ++index3);
                } else {
                    d[dIndex] = element1;
                    element1 = getElement(merge1, ++index1);
                }
            }
            else {
                if (element3 <= element2) {
                    d[dIndex] = element3;
                    element3 = getElement(merge3, ++index3);
                } else {
                    d[dIndex] = element2;
                    element2 = getElement(merge2, ++index2);
                }
            }
            dIndex++;
        }

    }
    static void mergeSort(int arr[]) {// merge sort recursive implemetation
        if (arr.length <= 1) return;//checks for small arrays
        int size1, size3;
        if (arr.length == 2) {
            size1 = 1;
            size3 = 0;
        }
        else {
            size1 = arr.length / 3;
            size3 = arr.length - 2*  size1;
        }
        int temp1[] = new int[size1];
        int temp2[] = new int[size1];
        int temp3[] = new int[size3];
        for (int i = 0; i < size1; i++) temp1[i] = arr[i];
        for (int i = 0; i < size1; i++) temp2[i] = arr[size1+i];
        for (int i = 0; i < size3; i++) temp3[i] = arr[2*size1 + i];
        //recursive calls
        mergeSort(temp1);
        mergeSort(temp2);
        mergeSort(temp3);
        merge(temp1, temp2, temp3, arr);
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
            mergeSort(arr);// Change this
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
            System.out.println( "Average Time of "+ tryy +" test cases with size of  "+size+" random numbers for Three Way Merge Sort: (" + finalTime+" milliseconds) ");
            System.out.println("Sorted array of last test case is ");
            //printArray(arr);//uncomment when sort needs to be read
        }



    }
    public static void printArray(int arr[]){
        for(int i : arr) System.out.print(i+" ");
    }
    public static void main(String args[]) {
        int sizeOfArray =10000;
        int numberOfTestCases = 100;
        check(sizeOfArray, numberOfTestCases);
    }

}
