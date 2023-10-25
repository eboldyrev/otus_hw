package eugene.boldyrev._10_linear_sorts;

import java.util.Random;

public class ArrayUtils {

    private ArrayUtils() {
    }

    public static void print(int[] arr){
        System.out.print("A = [");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.print("]");
        System.out.println();
    }

    public static int[] generateRandom(int count, int maxNumber){
        int[] A = new int[count];
        Random random = new Random(123456);
        for (int i = 0; i < count; i++) {
            A[i] = random.nextInt(maxNumber);
        }
        return A;
    }

    public static int[] ascendingOrder(int count){
        int[] A = new int[count];
        for (int i = 0; i < count; i++) {
            A[i] = i;
        }
        return A;
    }

    public static int[] descendingOrder(int count){
        int[] A = new int[count];
        for (int i = 0; i < count; i++) {
            A[i] = i;
        }
        return A;
    }



}
