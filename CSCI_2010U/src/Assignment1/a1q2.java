//Yash Dhume
//100653618
//Professor Samaneh Mazaheri
//CSCI 2010U
//2nd October 2018
//Assignment 1 Part 2
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class a1q2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of primes: ");
        int N = scan.nextInt();
        long startTime = System.nanoTime();
        List<Integer> primes = new ArrayList<>();
        if (N >= 1) primes.add(2);// adding the fist 2 elements
        if (N >= 2) primes.add(3);
        int num = 1;
        int count =2;
        while(primes.size()<N){//loop until the size of the array is N
            boolean isPrime =true;
            count = 6 - count;//helps count up by 4 then 2 to make it more efficient
            num += count;// num is the primes
            for(int i  : primes){//iterate through the array
                int size =primes.size();
                int sqrt = (int)(Math.sqrt(num));
                if(i>sqrt+1) break;//break for efficiency if i >  square root of the prime
                if(num%i==0){//if the primes is false
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) primes.add(num);//add in the array

        }
        long endTime = System.nanoTime();
        //System.out.print(primes);
        System.out.println(" ("+((endTime-startTime)/1000000d)+" milliseconds)");
    }
}
