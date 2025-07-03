package DSA.Strings;

public class _8_Sort_Vowels_in_a_String {

    public String sortVowels(String s) {
        int n = s.length();

        int[] upperCase = new int[26];
        int[] lowerCase = new int[26];

        StringBuilder middle = new StringBuilder(s);

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                upperCase[ch - 'A']++;
                middle.setCharAt(i, '#');
            } else if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                lowerCase[ch - 'a']++;
                middle.setCharAt(i, '#');
            }

        }

        StringBuilder sortedVowels = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            char ch = (char) ('A' + i);
            while (upperCase[i] != 0) {
                sortedVowels.append(ch);
                upperCase[i]--;
            }
        }

        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            while (lowerCase[i] != 0) {
                sortedVowels.append(ch);
                lowerCase[i]--;
            }
        }

        int index = 0;

        for (int i = 0; i < n; i++) {
            char ch = middle.charAt(i);
            if (ch == '#') {
                middle.setCharAt(i, sortedVowels.charAt(index));
                index++;
            }
        }

        return middle.toString();
    }
}
