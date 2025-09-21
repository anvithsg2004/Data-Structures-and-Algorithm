package DSA.Binary_Search;

import java.util.Arrays;

public class _21_Aggressive_Cows {

    public int maxDistance(int[] stalls, int cows) {

        int n = stalls.length;

        Arrays.sort(stalls);

        int low = 0;
        int high = stalls[n - 1] - stalls[0];

        int ans = 0;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (canPlaceCows(stalls, cows, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return ans;

    }

    public static boolean canPlaceCows(int[] stalls, int cows, int dist) {

        int n = stalls.length;

        int count = 1;
        int lastPosition = stalls[0];

        for (int i = 0; i < n; i++) {
            if (stalls[i] - lastPosition >= dist) {
                count++;
                lastPosition = stalls[i];
                if (count == cows) {
                    return true;
                }
            }
        }

        return false;

    }
}
