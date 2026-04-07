package DSA.Sliding_Window;

public class _12_Minimum_Window_Subsequence {
    public String minWindow(String s, String t) {

        int n = s.length();
        int m = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = -1;

        int i = 0;

        while (i < n) {

            int j = 0;

            // Step 1 : Forward Scan
            while (i < n) {
                if (s.charAt(i) == t.charAt(j)) {
                    j++;
                    if (j == m) {
                        break;
                    }
                }
                i++;
            }

            // If no subsequence found, stop
            if (i == n) {
                break;
            }

            int end = i;

            // Step 2 : backward Shrink
            j = m - 1;

            while (i >= 0) {
                if (s.charAt(i) == t.charAt(j)) {
                    j--;
                    if (j < 0) {
                        break; // minimized
                    }
                }
                i--;
            }

            int windowStart = i;

            if (end - windowStart < minLen) {
                minLen = end - windowStart;
                start = windowStart;
            }

            i = windowStart + 1;

        }

        return start == -1 ? "" : s.substring(start, start + minLen);

    }
}
