package eugene.boldyrev._8_simple_sorts;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

public class SortsMarket {

    private int N;
    private int[] A;

    public SortsMarket(int[] A) {
        initData(A);
    }

    public SortsMarket(int N) {
        this.N = N;
        A = new int[N];
    }

    public void setData(int[] A){
        initData(A);
    }

    private void initData(int[] A) {
        this.A = Arrays.copyOf(A, A.length);
        this.N = A.length;
    }

    public static int[] generateRandom(int N) {
        Random random = new Random(12345);
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = random.nextInt();
        }
        return A;
    }

    public Void bubbleSort() {
        for (int j = N - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (A[i] > A[i + 1])
                    swap(i, i + 1);
            }
        }
        return null;
    }

    public Void insertionSort() {
        for (int j = 1; j < N; j++) {
            for (int i = j - 1; i >= 0 && greater(A[i], A[i + 1]); i--) {
                swap(i, i + 1);
            }
        }
        return null;
    }

    public Void insertionSortWithShift() {
        int i;
        for (int j = 1; j < N; j++) {
            int k = A[j];
            for (i = j - 1; i >= 0 && greater(A[i], k); i--) {
                A[i + 1] = A[i];
            }
            A[i + 1] = k;
        }
        return null;
    }

    public Void insertionSortBinary() {
        int i;
        for (int j = 1; j < N; j++) {
            int k = A[j];
            int idx = binarySearch(k, 0, j - 1);
            for (i = j - 1; i >= idx; i--) {
                A[i + 1] = A[i];
            }
            A[i + 1] = k;
        }
        return null;
    }

    public Void shellSort(){
//        printArray(A);
        for (int gap = N / 2; gap > 0; gap /= 2) {
//            System.out.printf("Gap = %d\n", gap);
            for (int j = gap; j < N; j++) { // from middle to end
//                System.out.printf("j = %d\n", j);
                for (int i = j; i >= gap && greater(A[i - gap], A[i]); i -= gap) { // from middle to 0
                    swap(i - gap, i);
//                    printArray(A);
                }
            }
        }
        return null;
    }

    public void measure(Supplier<Void> algo) {
        long s = System.nanoTime();
        algo.get();
        long e = System.nanoTime();
        System.out.printf("It took %d ms\n", (e - s)/ 1_000_00);
    }

    private int binarySearch(int key, int low, int high) {
        if (high <= low) {
            if (key >= A[low])
                return low + 1;
            else
                return low;
        }
        int mid = (low + high) / 2;
        if (key >= A[mid]) {
            return binarySearch(key, mid + 1, high);
        } else {
            return binarySearch(key, low, mid - 1);

        }
    }

    private void swap(int i1, int i2) {
//        System.out.printf("%d <-> %d\n", A[i1], A[i2]);
        int a = A[i1];
        A[i1] = A[i2];
        A[i2] = a;
    }

    private boolean greater(int e1, int e2) {
        return e1 > e2;
    }

    private void printArray(int[] A){
        for (int e : A) {
            System.out.printf("%d ", e);
        }
        System.out.print("\n");
    }


    public static void main(String[] args) {
//        int[] A = {5, 3, 7, 4, 2, 9, 1, 0, 6, 8};

        for (int s = 10; s <= 10_000; s*=10) {
            int[] A = generateRandom(s);

            SortsMarket sortsMarket = new SortsMarket(A);
            System.out.printf("Bubble sort | Array size: %d | ", s);
            sortsMarket.measure(sortsMarket::bubbleSort);

            System.out.printf("Insertion sort | Array size: %d |", s);
            sortsMarket.setData(A);
            sortsMarket.measure(sortsMarket::insertionSort);

            System.out.printf("Shell sort | Array size: %d | ", s);
            sortsMarket.setData(A);
            sortsMarket.measure(sortsMarket::shellSort);
        }
    }
}
