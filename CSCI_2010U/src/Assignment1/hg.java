package Assignment1;

import java.util.*;
public class hg {

    public static void main(String[] args){
        int N = 243155135;
        ArrayList<Integer> primes = new ArrayList<>();

        boolean[] isPrime = new boolean[(N/2)];
        primes.add(2);
        for(int i =3; i<((int)( Math.sqrt(N) + 1));i+=2){
            if(!isPrime[(i/2)]){
                int j=(i*i)/2;
                while(j<(((int)(N/2)))){
                    isPrime[j]=true;
                    j+=i;
                }
            }
        }
        for(int i=3; i<N; i+=2){
            if(!isPrime[i/2]){
                primes.add(i);
            }
        }
        long endTime = System.nanoTime();
        System.out.println(primes.get(primes.size()-1));
        // System.out.println(primes);
    }
}




























