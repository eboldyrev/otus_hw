package eugene.boldyrev._3_power;

public class FastPower {

    private static double power(double a, long n){
        if (n == 0) return 1;
        if (n == 1) return a;

        if (n % 2 == 0) {
            double x = power(a, n / 2);
            return x * x;
        } else {
            return a * power(a, n - 1);
        }
    }

    public static void main(String[] args) {
        double a = 1.0000000001;
        long n = 10000000000L;
        System.out.printf("a=%10.9f n=%d result=%10.9f", a, n, power(a, n));
    }

}
