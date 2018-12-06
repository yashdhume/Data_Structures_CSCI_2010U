// @author Yash Dhume (100653618)
package Assignment3;
class FindMaxSubArray{
    int[] arr;
    int maxSum=0, firstIndex = 0, lastIndex = 0;
    FindMaxSubArray(int []arr){//Constructor
        this.arr = arr;
    }
    public void solveMaxSubArray() {//Solve Problem
        int  maxSumTemp = 0;
        int count = 0, startCount = 0;
        for (int i : arr) {//iterate through array
            maxSumTemp += i;//make temp sum the element
            if (maxSumTemp < 0) {//make counter go up if the temp sum is  less than 0
                maxSumTemp = 0;
                startCount = count + 1;
            }
            if (maxSumTemp > maxSum) {//if the temp sum is greater than final sum change values
                maxSum = maxSumTemp;
                firstIndex = startCount;
                lastIndex = count;
            }
            count++;
        }
    }
    public int getMaxSum(){//for the greatest  sum
        return maxSum;
    }
    public void printArray(){//Print Array;
        System.out.print('[');
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(arr[i]);
        }
        System.out.println(']');
    }
    public void printSubArray(){//Print Sub Array
        if(firstIndex==0&&lastIndex==0) System.out.println("[]");
        else{
            int[] subArr = new int[lastIndex - firstIndex + 1];
            for (int i = 0; i < subArr.length; i++) subArr[i] = arr[firstIndex + i];
            System.out.print('[');
            for (int i = 0; i < subArr.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(subArr[i]);
            }
            System.out.println(']');
        }
    }
}
public class MaxSubArray {
    public static void main(String[] args){
        int[] arr = {2, -4, 1, 9, -6, 7, -3};
        FindMaxSubArray a = new FindMaxSubArray(arr);
        System.out.print("Original Array: ");
        a.printArray();
        a.solveMaxSubArray();
        System.out.println("Sum:  "+a.getMaxSum());
        System.out.print("Sub Array: ");
        a.printSubArray();
    }
}
