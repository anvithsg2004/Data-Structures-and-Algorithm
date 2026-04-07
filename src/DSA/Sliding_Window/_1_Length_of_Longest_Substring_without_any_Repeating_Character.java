package DSA.Sliding_Window;

import java.util.*;

public class _1_Length_of_Longest_Substring_without_any_Repeating_Character {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int i = 0;
        int j = 0;

        int maxLength = 0;

        Set<Character> characterSet = new HashSet<>();

        while (j < n) {

            while (characterSet.contains(s.charAt(j))) {
                characterSet.remove(s.charAt(i));

                i++;
            }

            // Include
            characterSet.add(s.charAt(j));

            // Update the Max Length
            maxLength = Math.max(maxLength, j - i + 1);
            j++;

        }

        return maxLength;
    }
}
