package eugene.boldyrev._10_linear_sorts;

public class LinearSortsTest {

    public static void main(String[] args) {

        for (int i = 100; i < 10_000_000; i *= 10) {
            int[] ints = ArrayUtils.generateRandom(i, 1000);

            System.out.printf("Array size: %d \n", ints.length);

            CountingSort countingSort = new CountingSort(ints, 1000);
            System.out.print("Counting sort: ");
            AbstractSort.measure(countingSort);
            System.out.println();

            RadixSort radixSort = new RadixSort(ints, 10, 999);
            System.out.print("Radix sort: ");
            AbstractSort.measure(radixSort);
            System.out.println();

            BucketSort bucketSort = new BucketSort(ints);
            System.out.print("Bucket sort: ");
            AbstractSort.measure(bucketSort);
            System.out.println();
            System.out.println("---------------------------------------");
        }
    }
}
