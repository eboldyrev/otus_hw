package eugene.boldyrev._5_primes;

import eugene.boldyrev.testit.TestRunner;
import eugene.boldyrev.testit.Testable;

import java.util.List;

public class TestableEratosphen implements Testable {
    @Override
    public List<String> runTest(List<String> input) {
        Eratosphen eratosphen = new Eratosphen(Integer.parseInt(input.get(0)));
        return List.of(String.valueOf(eratosphen.countPrimes()));
    }

//    Test results
//    Test 0 took 0 ms | Result : Passed
//    Test 1 took 0 ms | Result : Passed
//    Test 2 took 0 ms | Result : Passed
//    Test 3 took 0 ms | Result : Passed
//    Test 4 took 0 ms | Result : Passed
//    Test 5 took 0 ms | Result : Passed
//    Test 6 took 0 ms | Result : Passed
//    Test 7 took 0 ms | Result : Passed
//    Test 8 took 0 ms | Result : Passed
//    Test 9 took 4 ms | Result : Passed
//    Test 10 took 16 ms | Result : Passed
//    Test 11 took 65 ms | Result : Passed
//    Test 12 took 979 ms | Result : Passed
//    Test 13 took 11083 ms | Result : Passed
//    Test 14 took 1042 ms | Result : Passed
//    All 15 tests finished: passed: 15, FAILED: 0, ERROR: 0

    public static void main(String[] args) {
        TestRunner testRunner = new TestRunner("C:\\Books\\Алгоритмы\\otus\\5.Primes", new TestableEratosphen());
        testRunner.runTests();
    }
}
