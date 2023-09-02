package eugene.boldyrev._7_bit_masks;

public class CountBits {

    static short countBits1(long l) {
        short result = 0;
        while (l > 0) {
            result += l & 1;
            l >>= 1;
        }
        return result;
    }
    static short countBits2(long l) {
        short result = 0;
        while (l > 0) {
            result ++;
            l &= l - 1;
        }
        return result;
    }
    static short countBits3(long l) {
        short result = 0;

        while (l > 0) {
            result += bits[(int)(l & 255)];
            l >>= 8;
        }
        return result;
    }

    static byte[] bits;

    static void initBits(){
        bits = new byte[256];
        for (int i = 0; i < 256; i++) {
            bits[i] = (byte) countBits2(i);
        }
    }

    public static void main(String[] args) {

        long s = System.nanoTime();
        short i = countBits1(275956895760L);
        long e = System.nanoTime();
        System.out.printf("Result %d for time %dns \n", i, (e-s) );

        s = System.nanoTime();
        i = countBits2(275956895760L);
        e = System.nanoTime();
        System.out.printf("Result %d for time %dns \n", i, (e-s) );

        initBits();
        s = System.nanoTime();
        i = countBits3(275956895760L);
        e = System.nanoTime();
        System.out.printf("Result %d for time %dns \n", i, (e-s) );

    }
}
