package DSA.Practice.Strings.Leetcode_Medium;

import java.util.HashMap;
import java.util.Map;

public class _7_Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram {

    public int minSteps(String s, String t) {

        Map<Character, Integer> frequency = new HashMap<>();

        // Count frequency of characters in string s
        for (int i = 0; i < s.length(); i++) {
            frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Decrease the frequency for characters in string t
        for (int i = 0; i < t.length(); i++) {
            frequency.put(t.charAt(i), frequency.getOrDefault(t.charAt(i), 0) - 1);
        }

        // Count the number of steps needed to make anagrams
        int count = 0;
        for (int value : frequency.values()) {
            if (value > 0) {
                count += value; // Only add positive values
            }
        }

        return count;

    }

    public static void main(String[] args) {

    }
}
