package DSA.Dynamic_Programming.Recursion;

import java.util.ArrayList;
import java.util.List;

public class _6_Kth_Permutation_Sequence {
    public static String getPermutation(int n, int k) {

        List<String> perms = new ArrayList<>();

        boolean[] used = new boolean[n + 1];

        help(n, "", perms, used);

        return perms.get(k - 1);
    }

    public static void help(int n, String current, List<String> perms, boolean[] used) {
        if (current.length() == n) {
            perms.add(current);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                used[i] = true;
                help(n, current + i, perms, used);
                used[i] = false;
            }
        }
    }
}
