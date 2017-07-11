package couting;

/**
 * Enumerate all N-digit base-R numbers.
 *
 * <p>
 * NOTE: This is from Bob Sedgewick's http://algs4.cs.princeton.edu/home/ course.
 * and is copyrighted to him and Kevin Wayne under GPLv3.
 */
public class Counter {

    private int N;
    private int R;
    private int[] a;

    public Counter(int N, int R) {
        this.N = N;
        this.R = R;
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

        for (int r = 0; r < R; r++) {
            a[k] = r;
            enumerate(k + 1);
        }
        // No clean up is needed.
    }

    public static void main(String[] args) {
        Counter counter = new Counter(2, 3);
    }

}
