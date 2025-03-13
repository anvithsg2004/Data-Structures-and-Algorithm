package DSA.Strings;

import java.util.HashMap;

public class _13_Smallest_distinct_window {
    public static String findSmallestWindow(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        // Step 1: Count all distinct characters in the input string
        int distinctCount = (int) str.chars().distinct().count();

        // Step 2: Initialize variables for sliding window and tracking frequency of characters
        int start = 0, minLength = Integer.MAX_VALUE;
        String result = "";

        HashMap<Character, Integer> charCount = new HashMap<>();

        int matchedDistinctChars = 0;

        // Step 3: Slide over the string with `end` pointer
        for (int end = 0; end < str.length(); end++) {
            char endChar = str.charAt(end);
            charCount.put(endChar, charCount.getOrDefault(endChar, 0) + 1);

            // If the character's frequency becomes 1, we found a new distinct character in the window
            if (charCount.get(endChar) == 1) {
                matchedDistinctChars++;
            }

            // Step 4: When we have all distinct characters, try to shrink the window
            while (matchedDistinctChars == distinctCount) {
                int windowLength = end - start + 1;

                // Update the result if the current window is smaller than the previously found the smallest window
                if (windowLength < minLength) {
                    minLength = windowLength;
                    result = str.substring(start, end + 1);
                }

                // Shrink the window from the left by moving `start`
                char startChar = str.charAt(start);
                charCount.put(startChar, charCount.get(startChar) - 1);

                // If the frequency of the starting character becomes 0, it means we removed one distinct character
                if (charCount.get(startChar) == 0) {
                    matchedDistinctChars--;
                }

                start++;
            }
        }

        return result;
    }
}
