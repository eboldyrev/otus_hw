package eugene.boldyrev._5_primes;

import java.util.ArrayList;
import java.util.BitSet;

public class Eratosphen {

    private BitSet a;

    private int n;

    private ArrayList<Integer> primes = new ArrayList<>();

    public Eratosphen(int n) {
        this.n = n;
        a = new BitSet(n);
        a.set(1);
    }

    public int countPrimes() {
        int max = (int) Math.sqrt(n) + 1;
        int i = 2;

        while (i < max) {
            while (a.get(i) && i < max) i++;

            for (int j = i + i; j <= n; j = j + i) {
                if (!a.get(j)) {
                    a.set(j);
                }
            }

            i++;

        }
        return n - a.cardinality();
    }

    public void printPrimes() {
        int b = 2;
        int prime;
        do {
            prime = a.nextClearBit(b);
            if (prime < n) {
                System.out.println(prime);
            }
            b = prime + 1;
        } while (prime != -1 && b < n);
    }

}
