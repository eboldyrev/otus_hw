package eugene.boldyrev._10_linear_sorts;

public class BucketSort extends AbstractSort {
    public BucketSort(int[] a) {
        setData(a);
    }

    public int[] sort() {
        int max = A[0];
        int N = A.length;
        for (int a: A) {
            if (a > max) {
                max = a;
            }
        }
        max++;

        List[] buckets = new List[N];
        for (int a: A) {
            int nr =  (a * N) / max;
            buckets[nr] = new List(a, buckets[nr]);

            List item = buckets[nr];
            while(item.next != null) {
                if  (item.value <=  item.next.value) break;

                int x = item.value;
                item.value = item.next.value;
                item.next.value = x;

                item = item.next;
            }
        }

        int j = 0;
        for (List item : buckets) {
            while (item != null) {
                A[j++] = item.value;
                item = item.next;
            }
        }

        return A;
    }

    static class List {
        int value;
        List next;

        public List(int value, List next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int [] A = ArrayUtils.generateRandom(100, 1000);
        ArrayUtils.print(A);
        BucketSort bucketSort = new BucketSort(A);
        int[] sorted = bucketSort.sort();
        ArrayUtils.print(sorted);
    }
}
