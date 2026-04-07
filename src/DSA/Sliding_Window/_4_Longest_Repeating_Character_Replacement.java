package DSA.Sliding_Window;

public class _4_Longest_Repeating_Character_Replacement {

    //Optimal Solution
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int i = 0;
        int j = 0;
        int maxLength = 0;
        int maxFreq = 0;

        int[] freq = new int[26];

        while (j < n) {

            // Include
            char letter = s.charAt(j);
            freq[letter - 'A']++;
            maxFreq = Math.max(maxFreq, freq[letter - 'A']);

            // Condition
            while ((j - i + 1) - maxFreq > k) {
                freq[s.charAt(i) - 'A']--;
                i++;
            }

            // Update
            maxLength = Math.max(maxLength, j - i + 1);
            j++;

        }

        return maxLength;
    }
}
