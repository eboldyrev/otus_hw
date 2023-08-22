package eugene.boldyrev._5_primes;


import java.util.function.Predicate;

public class PrimeNumbers {

    public long countPrimes(long n) {
        return countPrimes(n, PrimeNumbers::isPrime_3);
    }

    protected long countPrimes(long n, Predicate<Long> isPrimeFunc) {
        long counter = 0;
        for (long i = 2; i <= n; i++) {
            if (isPrimeFunc.test(i)) {
                counter++;
            }
        }
        return counter;
    }

    protected static boolean isPrime_1(Long n) {
        for (long i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    //
// Optimization 2
// N= 100 | Result : 25 | Time (ms): 2
// N= 1000 | Result : 168 | Time (ms): 2
// N= 10000 | Result : 1229 | Time (ms): 22
// N= 100000 | Result : 9592 | Time (ms): 1421
// N= 1000000 | Result : 78498 | Time (ms): 119493
    protected static boolean isPrime_2(Long n) {
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (long i = 3; i < n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Optimization 3
// N= 100 | Result : 25 | Time (ms): 3
// N= 1000 | Result : 168 | Time (ms): 1
// N= 10000 | Result : 1229 | Time (ms): 5
// N= 100000 | Result : 9592 | Time (ms): 34
// N= 1000000 | Result : 78498 | Time (ms): 288
// N= 10000000 | Result : 664579 | Time (ms): 8119
// N= 100000000 | Result : 5761455 | Time (ms): 189755
// N= 1000000000 | Result : 50847534 | Time (ms): 2076664
    protected static boolean isPrime_3(Long n) {
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        long k = (long) Math.sqrt(n) + 1;
        for (long i = 3; i < k; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeNumbers primeNumbers = new PrimeNumbers();

// System.out.println("Optimization 1");
// for (int i=100; i <= 1000000000; i*=10) {
// long b = System.nanoTime();
// long primes = simpleNumbers.countPrimes(i, SimpleNumbers::isPrime_1);
// long e = System.nanoTime();
// System.out.println("N= " + i+" | Result : " + primes + " | Time (ms): " + (e - b) / 1_000_000);
// }

// System.out.println("Optimization 2");
// for (int i=100; i <= 1000000000; i*=10) {
// long b = System.nanoTime();
// long primes = simpleNumbers.countPrimes(i, SimpleNumbers::isPrime_2);
// long e = System.nanoTime();
// System.out.println("N= " + i+" | Result : " + primes + " | Time (ms): " + (e - b) / 1_000_000);
// }

// System.out.println("Optimization 3");
// for (int i=100; i <= 1_000_000_000; i*=10) {
// long b = System.nanoTime();
// long primes = simpleNumbers.countPrimes(i, SimpleNumbers::isPrime_3);
// long e = System.nanoTime();
// System.out.println("N= " + i+" | Result : " + primes + " | Time (ms): " + (e - b) / 1_000_000);
// }

        // 7027260
        System.out.println(primeNumbers.countPrimes(123456789, PrimeNumbers::isPrime_3));

    }
}
