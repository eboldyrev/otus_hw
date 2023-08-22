package eugene.boldyrev._5_primes;

import eugene.boldyrev.testit.TestRunner;
import eugene.boldyrev.testit.Testable;

import java.util.List;

public class TestablePrimeNumbers implements Testable {
    @Override
    public List<String> runTest(List<String> input) {
        PrimeNumbers primeNumbers = new PrimeNumbers();
        primeNumbers.countPrimes(Integer.parseInt(input.get(0)));
        return List.of(""+primeNumbers.countPrimes(Integer.parseInt(input.get(0))));
    }

    public static void main(String[] args) {
        TestRunner testRunner = new TestRunner("C:\\Books\\Алгоритмы\\otus\\5.Primes", new TestablePrimeNumbers());
        testRunner.runTests();
    }
}
