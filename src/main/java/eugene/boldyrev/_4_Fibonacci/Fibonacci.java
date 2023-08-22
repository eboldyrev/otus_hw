package eugene.boldyrev._4_Fibonacci;

import eugene.boldyrev.testit.TestRunner;
import eugene.boldyrev.testit.Testable;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Function;

public class Fibonacci implements Testable {

    Function<Integer, String> algo;

    public Fibonacci(Function<Integer, String> algo) {
        this.algo = algo;
    }

    private static String fiboIterative(long n) {
        if (n == 0) return "0";

        BigInteger f0 = new BigInteger("0");
        BigInteger f1 = new BigInteger("1");

        for (long j = 1; j < n; j++) {
            BigInteger f2 = f0.add(f1);
            f0 = f1;
            f1 = f2;
        }

        return f1.toString();
    }

    private static String fiboMatrix(int n) {
        if (n == 0) return "0";

        BigInteger[][] zeroMatrix = new BigInteger[][]{
                {new BigInteger("1"), new BigInteger("1")},
                {new BigInteger("1"), new BigInteger("0")}
        };

        BigInteger[][] result = matrixPower(zeroMatrix, n - 1);

        return result[0][0].toString();
    }

    private static BigInteger[][] matrixPower(BigInteger[][] m, long n) {
        if (n == 0) {
            return new BigInteger[][]{
                    {new BigInteger("1"), new BigInteger("0")},
                    {new BigInteger("0"), new BigInteger("1")}
            };
        }

        if (n % 2 == 0) {
            BigInteger[][] y = matrixPower(m, n / 2);
            return matrixMultiplication(y, y);
        } else {
            BigInteger[][] y = matrixPower(m, (n - 1) / 2);
            BigInteger[][] y2 = matrixMultiplication(y, y);
            return matrixMultiplication(y2, m);
        }
    }

    private static BigInteger[][] matrixMultiplication(BigInteger[][] m1, BigInteger[][] m2) {
        BigInteger[][] result = new BigInteger[2][2];

        result[0][0] = m1[0][0].multiply(m2[0][0]).add(m1[0][1].multiply(m2[1][0]));
        result[1][0] = m1[1][0].multiply(m2[0][0]).add(m1[1][1].multiply(m2[1][0]));

        result[0][1] = m1[0][0].multiply(m2[0][1]).add(m1[0][1].multiply(m2[1][1]));
        result[1][1] = m1[1][0].multiply(m2[0][1]).add(m1[1][1].multiply(m2[1][1]));

        return result;
    }

    public List<String> runTest(List<String> input) {
        int n = Integer.parseInt(input.get(0));
        String s = algo.apply(n);
        return List.of(s);
    }

    public static void main(String[] args) {

        String testsPath = "C:\\Books\\Алгоритмы\\otus\\4.Fibo";

        System.out.println("Fibonacci matrix");
        TestRunner testRunner2 = new TestRunner(testsPath, new Fibonacci(Fibonacci::fiboMatrix));
        testRunner2.runTests();

        System.out.println("Fibonacci interactive");
        TestRunner testRunner = new TestRunner(testsPath, new Fibonacci(Fibonacci::fiboIterative));
        testRunner.runTests();

    }
}
