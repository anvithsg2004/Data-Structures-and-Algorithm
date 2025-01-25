package DSA.Sliding_Window;

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
                maxFreq = Math.max(maxFreq, hash[currentChar]); // Corrected line
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
