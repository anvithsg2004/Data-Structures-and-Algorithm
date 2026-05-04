package neetcode150._3_Sliding_Window;

public class _3_Longest_Repeating_Character_Replacement {
    public int characterReplacement(String s, int k) {

        int n = s.length();

        int maxFre = Integer.MIN_VALUE;
        char maxChar = 0;

        int[] fre = new int[26];

        int left = 0;
        int right = 0;

        int maxLength = 0;

        while (right < n) {

            char c = s.charAt(right);

            fre[c - 'A']++;

            if (fre[c - 'A'] > maxFre) {
                maxFre = Math.max(maxFre, fre[c - 'A']);
                maxChar = c;
            }

            while ((right - left) - maxFre > k) {

                char currentChar = s.charAt(left);

                fre[currentChar - 'A']++;

                if (currentChar == maxChar) {
                    maxFre--;
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);

            right++;

        }

        return maxLength;

    }
}
