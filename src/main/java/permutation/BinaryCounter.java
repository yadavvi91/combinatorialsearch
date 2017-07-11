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
        for (int i = 0; i < N; i++) {
            a[i] = 0; // Initialize the i-th bit to 0. This isn't necessary as an int[] is always initialized to 0.
        }
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

        enumerate(k + 1);
        a[k] = 1; // Change k-th position to 1
        enumerate(k + 1);
        a[k] = 0; // Change k-th position back to 0 i.e. cleanup.
    }

    public static void main(String[] args) {
        BinaryCounter counter = new BinaryCounter(4);
    }

}
