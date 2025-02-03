package DSA.Strings;

import java.util.HashSet;

public class _12_Longest_substring_without_repeating_characters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        HashSet<Character> hashSet = new HashSet<>();

        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {

            while (hashSet.contains(s.charAt(end))) {
                hashSet.remove(s.charAt(start));
                start++;
            }

            hashSet.add(s.charAt(end));

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
