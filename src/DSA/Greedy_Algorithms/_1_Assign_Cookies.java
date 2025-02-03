package DSA.Greedy_Algorithms;

import java.util.Arrays;

public class _1_Assign_Cookies {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int left = 0;  // For the children array
        int right = 0; // For the cookie array

        while (left < n && right < m) {
            if (g[left] <= s[right]) {
                left++; // Child is content, move to the next child
            }
            right++; // Move to the next cookie
        }

        return left; // The number of satisfied children
    }
}
