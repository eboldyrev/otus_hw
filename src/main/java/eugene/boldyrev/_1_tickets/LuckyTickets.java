package eugene.boldyrev._1_tickets;

public class LuckyTickets {

    private final int n;

    public LuckyTickets(int n) {
        this.n = n;
    }

    public long count() {
        if (n == 1) {
            return 10L;
        }

        long[] variants = new long[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        for (int nj = 2; nj <= n; nj++ ) {
            long[] tmp = new long[nj * 9 + 1];
            for (int i = 0; i < 9 + 1; i++) {
                for (int nc = 0; nc < variants.length; nc++) {
                    tmp[i + nc] = tmp[i + nc] + variants[nc];
                }
            }

            variants = tmp;
        }

        return sum(squareInPlace(variants));
    }

    private long sum(long[] a){
        long result = 0;
        for (long j : a) {
            result = result + j;
        }
        return result;
    }

    private long[] squareInPlace(long[] a){
        for (int i=0; i < a.length; i++) {
            a[i] = a[i] * a[i];
        }
        return a;
    }

}
