package DSA.Dynamic_Programming._7_DP_On_LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _3_Print_Longest_Increasing_Subsequence {
    public ArrayList<Integer> helper(int[] arr) {

        int n = arr.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];

        for (int i = 0; i < n; i++) {
            hash[i] = i;

            for (int previousIndex = 0; previousIndex < i; previousIndex++) {
                if (arr[previousIndex] < arr[i] && dp[previousIndex] + 1 > dp[i]) {
                    dp[i] = 1 + dp[previousIndex];
                    hash[i] = previousIndex;
                }
            }
        }

        int ans = -1;
        int lastIndex = -1;

        for (int i = 0; i < n; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[lastIndex]);

        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            answer.add(arr[lastIndex]);
        }

        Collections.reverse(answer);

        return answer;

    }
}
