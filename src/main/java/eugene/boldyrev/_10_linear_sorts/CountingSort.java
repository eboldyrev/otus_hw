package eugene.boldyrev._10_linear_sorts;

public class CountingSort extends AbstractSort {

    private int maxNumber;

    public CountingSort(int[] a, int maxNumber) {
        setData(a);
        this.maxNumber = maxNumber;
    }

    public int[] sort() {
        int[] digits = new int[maxNumber];

        for (int i : A) {
            digits[i]++;
        }

//        ArrayUtils.print(digits);

        int[] result = new int[A.length];

        int i = 0;
        for (int j = 0; j < digits.length; j++) {
            while (digits[j] > 0) {
                digits[j]--;
                result[i++] = j;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 2, 3, 3, 2, 0, 4, 2};  //generateRandom(10, 5);

        CountingSort countingSort = new CountingSort(A, 5);
        countingSort.print();
        int[] result = countingSort.sort();

        System.out.println("Result: ");
        ArrayUtils.print(result);
    }
}
