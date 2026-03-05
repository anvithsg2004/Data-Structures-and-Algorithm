class Solution {
    public int characterReplacement(String s, int k) {

        int n = s.length();

        int[] fre = new int[26];

        int left = 0;
        int right = 0;
        int maxLength = 0;
        int maxFreq = 0;

        for (right = 0; right < n; right++) {

            char c = s.charAt(right);
            fre[s.charAt(right) - 'A']++;

            maxFreq = Math.max(maxFreq, fre[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxFreq > k) {
                fre[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);

        }

        return maxLength;

    }
}
