package DSA.Binary_Search;

public class _14_Find_Nth_root_of_M {

    public int fun(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m) {
                return 2;
            }
        }
        if (ans == m) {
            return 1;
        }

        return 0;
    }

    public int NthRoot(int n, int m) {
        int low = 1;
        int high = m;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midN = fun(mid, n, m);
            if (midN == 1) {
                return mid;
            } else if (midN == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
