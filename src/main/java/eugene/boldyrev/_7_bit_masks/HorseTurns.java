package eugene.boldyrev._7_bit_masks;

public class HorseTurns {
    public static void main(String[] args) {
        long K = (1L << 3);
        long Ka = 0x7f7f7f7f7f7f7f7fL & K;
        long Kh = 0xfefefefefefefefeL & K;

        System.out.println(Long.valueOf(K));
        Long M = (Ka << 17) | (Kh << 15) | (Ka << 10)  | (Kh << 6)
                |(Ka >> 6) |(Kh >> 10) | (Ka >> 15) | (Kh >> 17);

        System.out.println(M);
    }
}
