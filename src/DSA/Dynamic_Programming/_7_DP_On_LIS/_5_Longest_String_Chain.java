package DSA.Dynamic_Programming._7_DP_On_LIS;

import java.util.*;

//This problem is about finding the longest chain of words where
//each word in the chain is formed by adding exactly one letter to the previous word.

public class _5_Longest_String_Chain {

    // Custom comparison function for sorting strings by length
    static Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();

    public boolean compare(String s1, String s2) {

        if (s1.length() != s2.length() + 1) {
            return false;
        }

        int first = 0;
        int second = 0;

        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }

        return first == s1.length() && second == s2.length();

    }

    public int longestStrChain(String[] words) {

        //We sort words by length.
        //We use DP to store the longest chain ending at each word.
        //We compare each word with previous words to find valid chains.
        //Final result: the longest chain length.

        int n = words.length;

        Arrays.sort(words, comp);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxi = 1;

        for (int i = 0; i < n; i++) {
            for (int previousIndex = 0; previousIndex < i; previousIndex++) {
                if (compare(words[i], words[previousIndex]) && 1 + dp[previousIndex] > dp[i]) {
                    dp[i] = 1 + dp[previousIndex];
                }
            }

            if (dp[i] > maxi) {
                maxi = dp[i];
            }
        }

        return maxi;

    }
}
