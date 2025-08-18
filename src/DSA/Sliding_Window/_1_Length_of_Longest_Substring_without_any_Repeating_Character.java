package DSA.Sliding_Window;

import java.util.*;

public class _1_Length_of_Longest_Substring_without_any_Repeating_Character {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashSet = new HashSet<>();

        int n = s.length();

        int left = 0;
        int right = 0;
        int len = 0;

        while (right < n) {

            char ch = s.charAt(right);

            while (hashSet.contains(ch)) {
                hashSet.remove(s.charAt(left));
                left = left + 1;
            }

            hashSet.add(ch);

            len = Math.max(len, right - left + 1);
            right++;
        }

        return len;
    }
}
