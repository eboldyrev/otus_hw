package eugene.boldyrev._10_linear_sorts;

public abstract class AbstractSort {

    protected int[] A;

    public abstract int[] sort() ;

    public void setData(int[] a) {
        A = new int[a.length];
        System.arraycopy(a, 0, A, 0, a.length);
    }

    public void print() {
        System.out.print("A = [");
        for (int i = 0; i < A.length; i++) {
            System.out.printf("%d ", A[i]);
        }
        System.out.print("]");
        System.out.println();
    }

    public static void measure(AbstractSort as) {
        long b = System.nanoTime();
        as.sort();
        long e = System.nanoTime();
        System.out.printf("%d ms", (e - b) / 1_000_000);
    }
}
