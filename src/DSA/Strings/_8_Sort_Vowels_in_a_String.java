package DSA.Strings;

public class _8_Sort_Vowels_in_a_String {

    public String sortVowels(String s) {
        int[] lower = new int[26];
        int[] upper = new int[26];

        // Count the vowels and replace them with '#'
        StringBuilder sb = new StringBuilder(s); // Use StringBuilder for efficient string manipulation
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                lower[ch - 'a']++;
                sb.setCharAt(i, '#'); // Replace it with '#' and update StringBuilder
            } else if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                upper[ch - 'A']++;
                sb.setCharAt(i, '#'); // Replace it with '#' and update StringBuilder
            }
        }

        StringBuilder sortedVowels = new StringBuilder();
        //Construct the sorted vowel string for uppercase
        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            while (upper[i] != 0) {
                sortedVowels.append(c);
                upper[i]--;
            }
        }

        //Construct the sorted vowel string for lowercase
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while (lower[i] != 0) {
                sortedVowels.append(c);
                lower[i]--;
            }
        }

        // Replace the '#' characters with the sorted vowels
        int vowelIndex = 0;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '#') {
                if (vowelIndex < sortedVowels.length()) {
                    sb.setCharAt(i, sortedVowels.charAt(vowelIndex)); // Replace it with the sorted vowel
                    vowelIndex++;
                }
            }
        }

        return sb.toString(); // Return the modified string
    }
}
