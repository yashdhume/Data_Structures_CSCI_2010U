package Assignment1;

import java.util.ArrayList;

public class h {
    public static void main(String[] args) {
        ArrayList<Integer> primes = new ArrayList<>();
        int N =1000000;
        long startTime = System.nanoTime();

        int prime = 1;
        int count = 2;
        while (primes.size() < N) {
            count = 6 - count;
            prime += count;

            for (int i : primes) {
                if (i > (int)prime / i) {
                    primes.add(prime);
                    break;
                }

                if (prime % i == 0) {
                    break;
                }
            }
        }
        long endTime = System.nanoTime();
        System.out.println(primes.get(primes.size()-1));
      //   System.out.println(primes);
        System.out.println("("+((endTime-startTime)/1000000d)+" milliseconds)");
    }
}

