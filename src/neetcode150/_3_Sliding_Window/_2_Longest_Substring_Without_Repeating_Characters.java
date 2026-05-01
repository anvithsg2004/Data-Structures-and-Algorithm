package neetcode150._3_Sliding_Window;

import java.util.HashSet;

public class _2_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        int left = 0;
        int right = 0;

        HashSet<Character> hashSet = new HashSet<>();

        int longest = 0;

        while (right < n) {

            Character c = s.charAt(right);

            while (hashSet.contains(c)) {
                Character beforeCharacter = s.charAt(left);
                hashSet.remove(beforeCharacter);
                left++;
            }

            longest = Math.max(longest, right - left + 1);

            hashSet.add(c);

            right++;

        }

        return longest;

    }
}
