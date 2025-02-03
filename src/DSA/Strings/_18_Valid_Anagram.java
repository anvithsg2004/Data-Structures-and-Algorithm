package DSA.Strings;

import java.util.HashMap;
import java.util.Map;

public class _18_Valid_Anagram {
    public boolean fun(String s, String t) {
        int sl = s.length();
        int tl = t.length();

        if (sl != tl) {
            return false;
        }

        int[] letters = new int[26];

        for (int i = 0; i < sl; i++) {
            letters[s.charAt(i) - 'a']++;  // Increment for string s
            letters[t.charAt(i) - 'a']--;  // Decrement for string t
        }

        for (int count : letters) {
            if (count != 0) {  // If any count is not zero, they are not anagrams
                return false;
            }
        }

        return true;
    }
}
