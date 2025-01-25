package DSA.Strings;

import java.util.HashMap;
import java.util.Map;

public class _18_Valid_Anagram {

    //Another Approach
    public boolean fun(String s, String t) {
        int sl = s.length();
        int tl = t.length();

        if (sl != tl) {
            return false;
        }

        int[] letters = new int[26];

        for (int i = 0; i < sl; i++) {
            letters[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < sl; i++) {
            letters[s.charAt(i) - 'a']--;
            if (letters[i] < 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram(String s, String t) {
        int sl = s.length();
        int tl = t.length();

        if (sl != tl) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < sl; i++) {

            Character sc = s.charAt(i);
            Character tc = t.charAt(i);

            map.put(sc, map.getOrDefault(sc, 0) + 1);
            map.put(tc, map.getOrDefault(tc, 0) + 1);

        }

        for (int i : map.values()) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
