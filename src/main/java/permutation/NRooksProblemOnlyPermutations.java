package permutation;

/**
 * How many ways are there to place N rooks on an N-by-N board so that
 * no rook can attack any other?
 * <p>
 * <i>We are only going to enumerate all the possible positions of the rooks.</i>
 */
public class NRooksProblemOnlyPermutations {

    private int N;
    /**
     * a[i] = j will represent a Rook in i-th row and j-th column.
     * And the values of i and j would be between 0 to N-1
     */
    private int[] a;

    public NRooksProblemOnlyPermutations(int N) {
        this.N = N;
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = i; // Initialize such that a rook is in k-th row and k-th column.
                      // for e.g. a[5] = 5 means a rook is in row 5 and column 5.
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
            enumerate(k + 1);
            exch(i, k);
        }
    }

    public static void main(String[] args) {
        NRooksProblemOnlyPermutations rooks = new NRooksProblemOnlyPermutations(4);
    }

}
