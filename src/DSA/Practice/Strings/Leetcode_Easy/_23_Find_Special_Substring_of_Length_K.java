package DSA.Practice.Strings.Leetcode_Easy;

import java.util.HashMap;

//Question: Find Special Substring of Length K
//Given a string s and an integer k, determine if there exists a special substring of length k.
//A substring is special if:
//It contains only one distinct character.
//It is not inside another sequence of the same character. That is, there should be a different
//character before and after the substring (if they exist in the string).

//Input:
//String s = "aaabbbaaa";
//int k = 3;

//Output:
//true

//Explanation:
//The substring "bbb" from index 3 to 5 satisfies both conditions:
//It contains only one distinct character ('b').
//The character before ('a') and after ('a') are different.

public class _23_Find_Special_Substring_of_Length_K {

    public boolean hasSpecialSubstring(String s, int k) {

        int n = s.length();

        for (int i = 0; i <= n - k; i++) {
            boolean before = false, after = false;
            String subString = s.substring(i, i + k);
            if (distinctOrNot(subString)) {
                if (i == 0 || s.charAt(i - 1) != s.charAt(i)) {
                    before = true;
                }

                // Check after
                if (i + k == n || (i + k < n && s.charAt(i + k) != s.charAt(i))) {
                    after = true;
                }

                if (before && after) {
                    return true;
                }
            }


        }

        return false;

    }

    public boolean distinctOrNot(String s) {

        HashMap<Character, Integer> freq = new HashMap<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (freq.size() > 1) {
            return false;
        }

        return true;

    }

}
