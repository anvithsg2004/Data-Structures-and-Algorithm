package DSA.Sliding_Window;

import java.util.*;

public class _11_Minimum_Window_Substring {
    public String minWindow(String s, String t) {

        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }

        // Frequency map for t
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int required = tMap.size(); // Unique chars needed
        int formed = 0; // How many chars matched

        Map<Character, Integer> sMap = new HashMap<>();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char c = s.charAt(right);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);

            if (tMap.containsKey(c) && sMap.get(c).intValue() == tMap.get(c).intValue()) {
                formed++;
            }

            // Try to shrink
            while (left <= right && formed == required) {

                char ch = s.charAt(left);

                // Update result
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Remove the window
                sMap.put(ch, sMap.get(ch) - 1);
                if (tMap.containsKey(ch) && sMap.get(ch) < tMap.get(ch)) {
                    formed--;
                }

                left++;
            }

            right++;

        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);

    }
}
