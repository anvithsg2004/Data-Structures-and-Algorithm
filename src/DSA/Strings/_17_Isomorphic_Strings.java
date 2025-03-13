package DSA.Strings;

import java.util.Arrays;

// Two strings s and t are isomorphic if the characters in s can be replaced to get t,
// while maintaining a one-to-one character mapping.

public class _17_Isomorphic_Strings {

    // Method to check if two strings are isomorphic
    public boolean fun(String s, String t) {

        // If the lengths are not the same, they can't be isomorphic
        if (s.length() != t.length()) {
            return false;
        }

        // Arrays to store character mappings
        int[] st = new int[256]; // Mapping from s -> t
        int[] ts = new int[256]; // Mapping from t -> s

        // Initialize arrays with -1 (indicating no mapping yet)
        Arrays.fill(st, -1);
        Arrays.fill(ts, -1);

        // Iterate through each character of the strings
        for (int i = 0; i < s.length(); i++) {

            char ss = s.charAt(i); // Character from string s
            char tt = t.charAt(i); // Character from string t

            // If this character hasn't been mapped yet
            if (st[ss] == -1 && ts[tt] == -1) {
                st[ss] = tt; // Map s[i] to t[i]
                ts[tt] = ss; // Map t[i] to s[i]
            }
            // If the character is already mapped but doesn't match, return false
            else if (st[ss] != tt || ts[tt] != ss) {
                return false;
            }
        }

        return true; // If all mappings are consistent, return true
    }

    /*
    Dry Run Example:
    Input:
    s = "egg", t = "add"

    Step-by-step execution:

    Step 1:
    i = 0, s[i] = 'e', t[i] = 'a'
    - 'e' is not mapped yet in st[]
    - 'a' is not mapped yet in ts[]
    - Map 'e' → 'a' and 'a' → 'e'

    Step 2:
    i = 1, s[i] = 'g', t[i] = 'd'
    - 'g' is not mapped yet in st[]
    - 'd' is not mapped yet in ts[]
    - Map 'g' → 'd' and 'd' → 'g'

    Step 3:
    i = 2, s[i] = 'g', t[i] = 'd'
    - 'g' is already mapped to 'd' in st[]
    - 'd' is already mapped to 'g' in ts[]
    - Mapping is consistent, continue

    Final Output: true ✅

    Edge Case:
    Input:
    s = "foo", t = "bar"

    Step 1:
    i = 0, s[i] = 'f', t[i] = 'b'
    - Map 'f' → 'b' and 'b' → 'f'

    Step 2:
    i = 1, s[i] = 'o', t[i] = 'a'
    - Map 'o' → 'a' and 'a' → 'o'

    Step 3:
    i = 2, s[i] = 'o', t[i] = 'r'
    - 'o' is already mapped to 'a' in st[]
    - But 'r' ≠ 'a', mapping conflict ❌

    Final Output: false ❌
    */
}
