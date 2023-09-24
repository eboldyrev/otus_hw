package eugene.boldyrev._8_simple_sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    public void setData(int[] A) {
        initData(A);
    }

    private void initData(int[] A) {
        this.A = Arrays.copyOf(A, A.length);
        this.N = A.length;
    }

    public static int[] generateRandom(int N) {
        Random random = new Random(728293);
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = random.nextInt();
        }
        return A;
    }
    public static List<String> generateRandomStrings(int N, int maxValue) {
        Random random = new Random(728293);
        List<String> A = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            A.add(random.nextInt(maxValue) + "");
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

    public Void selectionSort() {
        for (int j = N - 1; j > 0; j--) {
            swap(findMax(j), j);
        }
        return null;
    }

    public Void heapSort() {
        for (int root = A.length / 2 - 1; root >= 0; root--) {
            heapify(root, A.length);
        }

        for (int j = A.length - 1; j > 0; j--) {
            swap(0, j);
            heapify(0, j);
        }

        return null;
    }

    private void heapify(int root, int length) {
        int L = 2 * root + 1;
        int R = L + 1;

        int X = root;
        if (L < length && A[L] > A[X]) X = L;
        if (R < length && A[R] > A[X]) X = R;
        if (X == root) return;
        swap(X, root);
        heapify(X, length);
    }

    private int findMax(int j) {
        int maxIdx = 0;
        for (int i = 1; i < j; i++) {
            if (greater(A[i], A[maxIdx]))
                maxIdx = i;
        }
        return maxIdx;
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

    public Void shellSort() {
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

    public Void quickSort() {
        qSort(0, N - 1);
        return null;
    }

    private void qSort(int L, int R) {
        if (L >= R) return;
        int M = split(L, R);
        qSort(L, M - 1);
        qSort(M + 1, R);
    }

    private int split(int L, int R) {
        int P = A[R]; // pivot element
        int M = L - 1; // end of array part <=P

        for (int j = L; j <= R; j++) {
            if (greaterOrEqual(P, A[j])) {
                swap(++M, j);
            }
        }
        return M;
    }

    public Void mergeSort() {
        mSort(0, N - 1);
        return null;
    }

    private void mSort(int L, int R) {
        if (L >= R) return;
        int M = (L + R) / 2;
        mSort(L, M);
        mSort(M + 1, R);
        merge(L, M, R);
    }

    private void merge(int L, int M, int R){
        int[] tmp = new int[R - L + 1];
        int a = L;
        int b = M + 1;
        int m = 0;

        while (a <= M && b <= R) {
            if (greater(A[a], A[b]))  {
                tmp[m++] = A[b++];
            } else {
                tmp[m++] = A[a++];
            }
        }

        while (a <= M) {
            tmp[m++] = A[a++];
        }

        while (b <= R) {
            tmp[m++] = A[b++];
        }

        for (int i = L; i < R; i++) {
            A[i] = tmp[i - L];
        }
    }

    public void measure(Supplier<Void> algo) {
        long s = System.nanoTime();
        algo.get();
        long e = System.nanoTime();
        System.out.printf("%d ms\n", (e - s) / 1_000_000);
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

    private boolean greaterOrEqual(int e1, int e2) {
        return e1 >= e2;
    }

    private void printArray(int[] A) {
        for (int e : A) {
            System.out.printf("%d ", e);
        }
        System.out.print("\n");
    }

    private void printArray() {
        for (int e : A) {
            System.out.printf("%d ", e);
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
//        int[] A = {5, 3, 7, 4, 2, 9, 1, 0, 6, 8};
//        int[] A = {7, 3, 2, 9, 5, 0, 4, 8, 1};
//
//        SortsMarket sortsMarket = new SortsMarket(A);
//        sortsMarket.quickSort();
//        sortsMarket.printArray();

        for (int s = 100; s <= 10_000_000; s *= 10) {
            int[] A = generateRandom(s);

            SortsMarket sortsMarket = new SortsMarket(A);
//            System.out.printf("Bubble sort | Array size: %d | ", s);
//            sortsMarket.measure(sortsMarket::bubbleSort);

//            System.out.printf("Insertion sort | Array size: %d |", s);
//            sortsMarket.setData(A);
//            sortsMarket.measure(sortsMarket::insertionSort);

//            System.out.printf("Shell sort | Array size: %d | ", s);
//            sortsMarket.setData(A);
//            sortsMarket.measure(sortsMarket::shellSort);

//            System.out.printf("Selection sort | Array size: %d | ", s);
//            sortsMarket.setData(A);
//            sortsMarket.measure(sortsMarket::selectionSort);
//
//            System.out.printf("Heap sort | Array size: %d | ", s);
//            sortsMarket.setData(A);
//            sortsMarket.measure(sortsMarket::heapSort);
//
            System.out.printf("Quick sort | Array size: %d | ", s);
            sortsMarket.setData(A);
            sortsMarket.measure(sortsMarket::quickSort);

            System.out.printf("Merge sort | Array size: %d | ", s);
            sortsMarket.setData(A);
            sortsMarket.measure(sortsMarket::mergeSort);

        }
    }
}
