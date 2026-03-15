package DSA.Subarrays._3_Variable_Sliding_Window;

import java.util.HashSet;

public class _3_Longest_Substring_Without_Repeating_Characters {
    public static int longestSubstring(String s) {

        int n = s.length();

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            maxLen = Math.max(maxLen, right - left + 1);

        }

        return maxLen;

    }
}
