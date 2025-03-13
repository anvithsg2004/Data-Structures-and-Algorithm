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

    //Brute Force Solution
    public int characterReplacement2(String s, int k) {

        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int[] hash = new int[26];
            int maxFreq = 0;
            for (int j = i; j < n; j++) {
                int currentChar = s.charAt(j) - 'A';
                hash[currentChar]++;
                maxFreq = Math.max(maxFreq, hash[currentChar]);
                int changes = (j - i + 1) - maxFreq;
                if (changes <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }

        return maxLen;

    }

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
