package eugene.boldyrev._10_linear_sorts;

public class RadixSort extends AbstractSort {

    private int base;

    private int maxNumber;

    public RadixSort(int[] a, int base, int maxNumber) {
        this.base = base;
        this.maxNumber = maxNumber;
        setData(a);
    }

    public int[] sort() {
        for (int exp = 1; exp < maxNumber; exp *= base) {
            A = countingSortForDigits(exp);
//            ArrayUtils.print(A);
//            System.out.println("---------------------");
        }
        return A;
    }

    private int[] countingSortForDigits(int exp) {
//        System.out.println("exp = " + exp);
        int[] digits = new int[base];

        for (int i = 0; i < A.length; i++) {
            digits[digit(A[i], exp)]++;
        }

//        ArrayUtils.print(digits);

        // convert to indexes
        for (int i = 1; i < digits.length; i++) {
            digits[i] = digits[i] + digits[i - 1];
        }

//        ArrayUtils.print(digits);

        int[] result = new int[A.length];

        for (int i = A.length-1; i >= 0; i--) {
            int digit = digit(A[i], exp);
            digits[digit]--;
            result[digits[digit]] = A[i];
        }

        return result;
    }

    private int digit(int a, int exp){
        return a / exp % base;
    }

    public static void main(String[] args) {
        int[] A = {21, 32, 41, 12, 11, 52, 22};  //generateRandom(10, 5);

        RadixSort radixSort = new RadixSort(A, 10, 100);
        radixSort.print();
        int[] sorted = radixSort.sort();
        ArrayUtils.print(sorted);


//        int[] result = linearTimeSorts.countingSort();
//
//        System.out.println("Result: ");

//        System.out.println(123 / 1 % 10);
//        System.out.println(123 / 10 % 10);
//        System.out.println(123 / 100 % 10);
    }
}
