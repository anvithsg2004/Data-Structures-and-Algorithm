package DSA.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class _11_Minimum_Window_Substring {
    public static String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        // Map to store frequency of characters in t
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // Map to store frequency of characters in the current window
        Map<Character, Integer> windowMap = new HashMap<>();

        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        int required = tMap.size();  // Number of unique characters in t that need to be present in the window
        int formed = 0;  // Number of unique characters in the current window that match the required frequency in t

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            // Check if the current character in the window matches the required frequency in t
            if (tMap.containsKey(rightChar) && windowMap.get(rightChar).intValue() == tMap.get(rightChar).intValue()) {
                formed++;
            }

            // Try to contract the window until it ceases to be 'desirable'
            while (left <= right && formed == required) {
                char leftChar = s.charAt(left);

                // Update the minimum window if a smaller window is found
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }

                // Remove the leftmost character from the window
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (tMap.containsKey(leftChar) && windowMap.get(leftChar) < tMap.get(leftChar)) {
                    formed--;
                }

                left++;
            }

            // Expand the window by moving the right pointer
            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}
