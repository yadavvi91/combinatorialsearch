package backtracking;

/**
 * How many ways are there to place N queens on an N-by-N board so that
 * no queen can attack any other?
 *
 * <p>
 * NOTE: This is from Bob Sedgewick's http://algs4.cs.princeton.edu/home/ course.
 * and is copyrighted to him and Kevin Wayne under GPLv3.
 */
public class NQueens {

    private int N;
    /**
     * a[i] = j will represent a Queen in i-th row and j-th column.
     * And the values of i and j would be between 0 to N-1
     */
    private int[] a;

    public NQueens(int N) {
        this.N = N;
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = i; // Initialize such that a queen is in k-th row and k-th column.
                      // for e.g. a[5] = 5 means a queen is in row 5 and column 5.
        }

        enumerate(0);
    }

    private void process() {
        for (int val : a) {
            System.out.printf("%d", val);
        }
        System.out.println();
    }

    private void exch(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private void enumerate(int k) {
        if (k == N) {
            process();
            return;
        }

        for (int i = k; i < N; i++) {
            exch(k, i);
            if (!canBacktrack(k)) enumerate(k + 1);
            exch(i, k);
        }
    }

    private boolean canBacktrack(int k) {
        for (int i = 0; i < k; i++) {
            if ((a[i] - a[k]) == (k - i)) return true;
            if ((a[k] - a[i]) == (k - i)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        NQueens rooks = new NQueens(4);
    }

}
