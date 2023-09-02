package eugene.boldyrev._7_bit_masks;

public class KingTurns {
    public static void main(String[] args) {
        long K = 1L << 39;
        long Ka = 0xfefefefefefefefeL & K;
        long Kh = 0x7f7f7f7f7f7f7f7fL & K;
        System.out.println(K);
        long M = (Ka << 7) | (K << 8) | (Kh << 9)
                | (Ka >> 1)           | (Kh << 1)
                | (Ka >> 9)| (K >> 8) | (Kh >> 7);

        System.out.println(M);
    }
}
