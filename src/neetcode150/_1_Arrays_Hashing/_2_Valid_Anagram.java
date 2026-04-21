package neetcode150._1_Arrays_Hashing;

public class _2_Valid_Anagram {
    public boolean isAnagram(String s, String t) {

        int[] fre = new int[26];

        // Increase Fre
        for (int i = 0; i < s.length(); i++) {

            int index = s.charAt(i) - 'a';

            fre[index]++;

        }

        // Decrease Fre
        for (int i = 0; i < t.length(); i++) {

            int index = t.charAt(i) - 'a';

            fre[index]--;

        }

        // Check
        for (int i = 0; i < 26; i++) {
            if (fre[i] != 0) {
                return false;
            }
        }

        return true;

    }
}
