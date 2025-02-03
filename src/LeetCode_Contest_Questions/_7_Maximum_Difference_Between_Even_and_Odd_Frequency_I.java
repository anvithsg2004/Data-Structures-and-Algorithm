package LeetCode_Contest_Questions;

import java.util.Arrays;

public class _7_Maximum_Difference_Between_Even_and_Odd_Frequency_I {
    public static int maxDifference(String s) {

        int[] hashing = new int[26];

        int n = s.length();

        for (int i = 0; i < n; i++) {
            hashing[s.charAt(i) - 'a']++;
        }

        System.out.println(Arrays.toString(hashing));

        int maxOdd = 0; // Initialize to 0 or Integer.MIN_VALUE
        int minEven = Integer.MAX_VALUE; // Initialize to a large value

        for (int i = 0; i < 26; i++) {
            // Even Number
            if (hashing[i] % 2 == 0 && hashing[i] != 0) {
                minEven = Math.min(minEven, hashing[i]);
            }

            // Odd Number
            if (hashing[i] % 2 == 1) {
                maxOdd = Math.max(maxOdd, hashing[i]);
            }
        }

        return maxOdd - minEven;

    }

    public static void main(String[] args) {
        String s = "mmsmsym";
        System.out.println(maxDifference(s));
    }
}
