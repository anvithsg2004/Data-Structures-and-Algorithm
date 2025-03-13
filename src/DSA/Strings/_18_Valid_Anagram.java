package DSA.Strings;

public class _18_Valid_Anagram {

    public boolean fun(String s, String t) {
        int sl = s.length();
        int tl = t.length();

        // If lengths are not the same, they can't be anagrams
        if (sl != tl) {
            return false;
        }

        // Array to store the frequency of each letter (only lowercase letters)
        int[] letters = new int[26];

        // Traverse both strings
        for (int i = 0; i < sl; i++) {
            letters[s.charAt(i) - 'a']++;  // Increment count for s[i]
            letters[t.charAt(i) - 'a']--;  // Decrement count for t[i]
        }

        // Check if all frequencies are zero
        for (int count : letters) {
            if (count != 0) {  // If any count is not zero, they are not anagrams
                return false;
            }
        }

        return true;  // If all counts are zero, the strings are anagrams
    }

    /*
    Dry Run Example:
    -----------------
    Input:
    s = "listen"
    t = "silent"

    Step 1: Check length
    "listen" has 6 characters, "silent" has 6 characters → continue ✅

    Step 2: Update frequency array (letters[])

    i = 0: 'l' → letters['l' - 'a']++, 's' → letters['s' - 'a']--
    i = 1: 'i' → letters['i' - 'a']++, 'i' → letters['i' - 'a']--
    i = 2: 's' → letters['s' - 'a']++, 'l' → letters['l' - 'a']--
    i = 3: 't' → letters['t' - 'a']++, 'e' → letters['e' - 'a']--
    i = 4: 'e' → letters['e' - 'a']++, 'n' → letters['n' - 'a']--
    i = 5: 'n' → letters['n' - 'a']++, 't' → letters['t' - 'a']--

    Final letters[]: All values are 0 ✅

    Step 3: Check frequency array
    - Since all values are 0, s and t are anagrams.

    Output: true ✅

    -------------------------------------
    Edge Case Example:
    s = "hello", t = "world"

    Step 1: Lengths are the same ✅
    Step 2: Frequency array is updated
    Step 3: Non-zero values in letters[] → return false ❌

    Output: false ❌
    */
}
