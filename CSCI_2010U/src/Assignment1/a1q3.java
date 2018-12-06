//Yash Dhume
//100653618
//Professor Samaneh Mazaheri
//CSCI 2010U
//2nd October 2018
//Assignment 1 Part 3

/*
This program is done in O(logN) time. Doing it in O(N) time will be slow as its linear so it checks each number one by
one until it finds the the rotated point. Using O(logN) uses binary search. After checking if the array is empty or already
sorted, it starts the binary search. It starts with 3 variables. Start which is index 0, end with is the length of the array -1
and middle which is start and the end divided by 2. It loops until start is less than or equal to end. It first checks if the
middle is larger than the next element after middle, as that would be the rotated point. Then it will check if the start element
and the middle element and see if the start is less then or equal too  the middle then that means that the rotated point is
in the 2nd half, as the first half is know to be sorted. If it was false, then the first half has the rotated point as the 2nd half
sorted. It does this until the middle point is the rotated array.
*/
/*
if array length is 0 or array is null
    return -1;
if array leth is 1 or array 0 is less than array index array length -1
    return 0
while start is less than equal to end
    middle is ths start plus end divided by 2
    if middle more then index after middle in array
        return middle +1
    else if start array is less than middle array
        start = middle +1
    else
        end = middle -1
  return 0
*/

public class a1q3 {
    public static int FindRotatedIndexLogN(int arr[]) {
        if (arr == null || arr.length == 0)//If its empty
            return -1;
        if (arr.length == 1 || arr[0] < arr[arr.length - 1])//If its not rotated
            return 0;
        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid < arr.length-1 && arr[mid] > arr[mid+1])//checks if its the rotated point
                return (mid + 1);
            else if (arr[start] <= arr[mid])//if true the rotated pint will be in the 2nd half
                start = mid + 1;
            else
                end = mid - 1;//if true the rotated point will be in the 1st half
        }
        return 0;


    }
    public static void main(String [] args) {
        int[] list = new int [] {11, 14, 17, 2, 4, 5, 7, 9};//3
        int[] list2 = new int[]{15,16, 2, 4, 5, 7, 9};// 2
        int[] list3 = new int[]{2,4,5,6,7,8,9,10};//0
        int[] list4 = new int[]{2,3,4,5,6,7,8,9,0};//8
        int[] list5 = new int[]{1,0};//1
        int[] list6 = new int[]{1};//0
        int[] list7 = new int[]{5, 5, 4, 4, 4, 5, 5, 5};//2
        int[] list8 = new int[]{5, 5, 5, 5, 5};//0
        int[] list9 = new int[]{};//-1
        System.out.println(FindRotatedIndexLogN(list));
        System.out.println(FindRotatedIndexLogN(list2));
        System.out.println(FindRotatedIndexLogN(list3));
        System.out.println(FindRotatedIndexLogN(list4));
        System.out.println(FindRotatedIndexLogN(list5));
        System.out.println(FindRotatedIndexLogN(list6));
        System.out.println(FindRotatedIndexLogN(list7));
        System.out.println(FindRotatedIndexLogN(list8));
        System.out.println(FindRotatedIndexLogN(list9));


    }
}
