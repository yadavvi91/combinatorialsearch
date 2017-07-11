package permutation;

/**
 * Enumerate N-bit strings (Generate all possible N-bit binary numbers).
 */
public class BinaryCounter {

    private int N;
    private int[] a;

    public BinaryCounter(int N) {
        this.N = N;
        this.a = new int[N];
        enumerate(0);
    }

    private void process() {
        for (int val : a) {
            System.out.printf("%d", val);
        }
        System.out.println();
    }

    private void enumerate(int k) {
        if (k == N) {
            process();
            return;
        }

        a[k] = 0;
        enumerate(k + 1);
        a[k] = 1;
        enumerate(k + 1);
    }

    public static void main(String[] args) {
        BinaryCounter counter = new BinaryCounter(4);
    }

}
