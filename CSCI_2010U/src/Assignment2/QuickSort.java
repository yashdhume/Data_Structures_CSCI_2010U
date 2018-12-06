package Assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuickSort {
    public static int assignmentOperatorQuickSort =0;
    public static int assignmentOperatorQuickSort3 = 0;
    public static void swap(int[] arr, int a, int b) {//swap
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        assignmentOperatorQuickSort+=3;
        assignmentOperatorQuickSort3+=3;
    }
    public static int partition(int[] arr, int l, int r, int pivot) {//partition for the pi
        int tL = l;//temp left pointer
        int tR = r - 1;//temp right pointer
        while (true) {
            while (arr[++tL] < pivot) assignmentOperatorQuickSort3++;//loops temp left incresing
            while (arr[--tR] > pivot) assignmentOperatorQuickSort3++;//loops temp right decresing
            if (tL >= tR) break;//breaks when complete
            else swap(arr, tL, tR);
        }
        swap(arr, tL, r - 1);
        return tL;//return the left pointer
    }
    private static int partition2(int arr[], int l, int r, int piv) {
        int tL = l-1;//temp left pointer
        for (int i=l; i<r; i++)//loops unitll left reaches r
            if (arr[i] <= piv)swap(arr, ++tL, i);
            assignmentOperatorQuickSort+=2;
        swap(arr, tL+1, r);
        return tL+1;
    }
    public static void quickSort(int[] arr) { sort(arr, 0, arr.length - 1); }//call

    public static void sort(int[] arr, int l, int r) {
        if(l<r){
            if ((r-l+1> 3)) {//only if array isnt 3 slements or smaller
                int piv = arr[r];
                int partition = partition2(arr, l, r, piv);//calls partiion
                sort(arr, l, partition - 1);//sort recurstion
                sort(arr, partition, r);
                assignmentOperatorQuickSort+=2;
            }
            else manualSort(arr, l, r);//checks for array of 3

        }
    }
    public static int median(int[] arr, int l, int r) {
        int m = (l + r) / 2;//median
        if (arr[l] > arr[r]) swap(arr, l, r);//swap if left less than right
        if (arr[l] > arr[m]) swap(arr, l, m);//swap left middle
        if (arr[m] > arr[r]) swap(arr, r, m);// swap middle right
        swap(arr, m, r-1);
        assignmentOperatorQuickSort3++;
        return arr[r-1];
    }
    public static void quickSortMedianOfThree(int[] arr) {
        sortMedianOfThree(arr, 0, arr.length - 1);
    }
    public static void sortMedianOfThree(int[] arr, int l, int r) {

        if (l<r) {
            if ((r-l+1>= 3)) {
                int piv = median(arr, l, r);//median of 3
                int partition = partition(arr, l, r, piv);
                sortMedianOfThree(arr, l, partition - 1);
                sortMedianOfThree(arr, partition + 1, r);
                assignmentOperatorQuickSort3++;
            }
            else manualSort(arr, l,r);

        }
    }

    public static  void manualSort(int[] a,int left, int right) {
        int size = right - left + 1;
        if (size <= 1) return;//if array is size 1
        if (size == 2) {//if arra is size 2
            if (a[left] > a[right]) swap(a,left, right);// if array is size 3
            assignmentOperatorQuickSort++;
            assignmentOperatorQuickSort3++;
            return;
        }
        else{
            if (a[left] > a[right - 1]) swap(a,left, right - 1);
            if (a[left] > a[right]) swap(a,left, right);
            if (a[right - 1] > a[right]) swap(a,right - 1, right);
        }
    }
    public static void printArray(int arr[]){
        for(int i : arr) System.out.print(i+" ");
    }

    private static void checkRandom(int size, int tries){
        int[] arr = new int[size];
        int[] arr2 = new int[size];
        double finalTime=0,finalTime3 =0;
        Random rnd = new Random();
        System.out.println();
        System.out.println("FOR ARRAY WITH RANDOM NUMBERS: \n");
        ArrayList<Integer> arrCheck = new ArrayList<>();
        ArrayList<Double> avg = new ArrayList<>();
        ArrayList<Double> avg2 = new ArrayList<>();
        int tryy = tries;
        while(tries>0) {
            arrCheck.clear();
            assignmentOperatorQuickSort=0;
            assignmentOperatorQuickSort3=0;
            for (int i = 0; i < size; i++) {
                int r = rnd.nextInt(Integer.MAX_VALUE);
                arrCheck.add( r);
                arr[i] = r;
                arr2[i]=r;
            }
            Collections.sort(arrCheck);
            double startTime, endTime;
            startTime = System.nanoTime();
            quickSort(arr);
            endTime =System.nanoTime();
            double time = ((endTime-startTime)/1000000d);
            avg.add(time);
            startTime = System.nanoTime();
            quickSortMedianOfThree(arr2);
            endTime = System.nanoTime();
            time = ((endTime-startTime)/1000000d);
            avg2.add(time);

            for(int i =0; i<size; i++){
                if(arr[i] != arrCheck.get(i) && arr2[i]!=arrCheck.get(i)){
                    System.out.println("Error");
                    for (int j: arr) System.out.print (j+ " ");
                    System.out.println();
                    for(int j: arrCheck) System.out.print (j+ " ");
                    break;
                }
            }
            //System.out.println("No errors");
            //System.out.println(" ("+ +((endTime-startTime)/1000000d)+" milliseconds)");
            tries--;
        }
        double sum = 0;
        if(!avg.isEmpty()) {
            for (double i: avg) {
                sum += i;
            }
            finalTime = (sum / avg.size());
            System.out.println( "Average Time of "+ tryy +" test cases with size of  "+size+" random numbers for quick sort with pivot as last: (" + finalTime+" milliseconds) and the assignment count = "+ assignmentOperatorQuickSort);

        }
        double sum2 = 0;
        if(!avg2.isEmpty()) {
            for (double i: avg2) {
                sum2 += i;
            }
            finalTime3 = (sum2 / avg2.size());
            System.out.println( "Average Time of "+ tryy +" test cases with size of "+size+" random numbers for quick 3 median sort: (" + finalTime3+" milliseconds) and the assignment count = "+ assignmentOperatorQuickSort3);
        }

       // printArray(arr);//quick sort last pivot // comment for smaller array
        System.out.println();
        if(finalTime3<finalTime) System.out.println("The difference in time is "+ (finalTime-finalTime3) + " milliseconds. Therefore Quick sort with Median of 3 pivot is faster. ");
        else System.out.println("The difference in time is "+ (finalTime3-finalTime) + " milliseconds. Therefore Quick Sort with last element pivot is faster");
        if(assignmentOperatorQuickSort3>assignmentOperatorQuickSort) System.out.println("The difference in assignmnet operators is " + (assignmentOperatorQuickSort3-assignmentOperatorQuickSort) + " operations ");
        else System.out.println("The difference in assignmnet operators is " + (assignmentOperatorQuickSort-assignmentOperatorQuickSort3) + "operations ");

        // printArray(arr2);//quick sort median of 3 // comment for smaller array

    }
    private static void checkReverse(int size, int tries){
        int[] arr = new int[size];
        int[] arr2 = new int[size];
        double finalTime3=0, finalTime=0;
        assignmentOperatorQuickSort=0;
        assignmentOperatorQuickSort3=0;
        System.out.println("FOR REVERSE ARRAY:\n");
        ArrayList<Integer> arrCheck = new ArrayList<>();
        ArrayList<Double> avg = new ArrayList<>();
        ArrayList<Double> avg2 = new ArrayList<>();
        int tryy = tries;
        while(tries>0) {
            arrCheck.clear();
            for (int i = size, index=0; i >0; i--) {
                arrCheck.add(i);
                arr[index] = i;
                arr2[index]=i;
                index++;
            }
            Collections.sort(arrCheck);
            double startTime, endTime;
            startTime = System.nanoTime();
            quickSort(arr);
            endTime =System.nanoTime();
            double time = ((endTime-startTime)/1000000d);
            avg.add(time);
            startTime = System.nanoTime();
            quickSortMedianOfThree(arr2);
            endTime = System.nanoTime();
            time = ((endTime-startTime)/1000000d);
            avg2.add(time);

            for(int i =0; i<size; i++){
                if(arr[i] != arrCheck.get(i) && arr2[i]!=arrCheck.get(i)){
                    System.out.println("Error");
                    for (int j: arr) System.out.print (j+ " ");
                    System.out.println();
                    for(int j: arrCheck) System.out.print (j+ " ");
                    break;
                }
            }
           // System.out.println("No errors");
            //System.out.println(" ("+ +((endTime-startTime)/1000000d)+" milliseconds)");
            tries--;
        }
        double sum = 0;
        if(!avg.isEmpty()) {
            for (double i: avg) {
                sum += i;
            }
            finalTime = (sum / avg.size());
            System.out.println( "Average Time of "+ tryy +" test cases with size of  "+size+" random numbers for quick sort with pivot as last: (" + finalTime+" milliseconds) and the assignment count = "+ assignmentOperatorQuickSort);

        }
        double sum2 = 0;
        if(!avg2.isEmpty()) {
            for (double i: avg2) {
                sum2 += i;
            }
            finalTime3 = (sum2 / avg2.size());
            System.out.println( "Average Time of "+ tryy +" test cases with size of "+size+" random numbers for quick 3 median sort: (" + finalTime3+" milliseconds) and the assignment count = "+ assignmentOperatorQuickSort3);
        }

        // printArray(arr);//quick sort last index // comment for smaller array
        System.out.println();
        if(finalTime3<finalTime) System.out.println("The difference in time is "+ (finalTime-finalTime3) + " milliseconds. Therefore Quick sort with Median of 3 pivot is faster. ");
        else System.out.println("The difference in time is "+ (finalTime3-finalTime) + " milliseconds. Therefore Quick Sort with last element pivot is faster");
        if(assignmentOperatorQuickSort3>assignmentOperatorQuickSort) System.out.println("The difference in assignmnet operators is " + (assignmentOperatorQuickSort3-assignmentOperatorQuickSort) + " operations ");
        else System.out.println("The difference in assignmnet operators is " + (assignmentOperatorQuickSort-assignmentOperatorQuickSort3) + "operations ");

        // printArray(arr2);//quick sort last element// comment for smaller array

    }


    public static void main(String[] args) {
        int sizeOfArray = 10000;
        int numberOfTestCases = 100;
        checkRandom(sizeOfArray, numberOfTestCases);
        System.out.println();
        for(int i =0; i<5; i++) System.out.println("||||||||||");
        System.out.println();
        checkReverse(sizeOfArray,numberOfTestCases);
    }

}