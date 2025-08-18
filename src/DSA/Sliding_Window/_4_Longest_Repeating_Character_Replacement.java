package DSA.Sliding_Window;

//Problem Statement: Longest Repeating Character Replacement
//Given a string s consisting of uppercase English letters and an integer k,
//you can choose at most k characters in the string and replace them with any character.
//Your goal is to find the length of the longest substring that contains the same character
//after performing the replacements.

//s = "ABAB"
//k = 2
//Output:
//4
//You can replace both 'A's with 'B' or both 'B's with 'A', forming "BBBB" or "AAAA",
//which has a length of 4.

//s = "AABABBA"
//k = 1
//Output: 4
//Replace one 'B' with 'A' to form "AAAABBA" or replace an 'A' with 'B' to form "AABBBBA",
//both resulting in the longest substring of length 4.

public class _4_Longest_Repeating_Character_Replacement {

    //Optimal Solution
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int maxLength = 0;

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            count[currentChar - 'A']++;
            maxFreq = Math.max(maxFreq, count[currentChar - 'A']);

            while (right - left + 1 - maxFreq > k) {
                char leftChar = s.charAt(left);
                count[leftChar - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
