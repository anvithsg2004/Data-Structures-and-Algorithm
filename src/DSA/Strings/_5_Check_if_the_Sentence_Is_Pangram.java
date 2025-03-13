package DSA.Strings;

import java.util.*;

public class _5_Check_if_the_Sentence_Is_Pangram {
    //Code checks whether a sentence is a pangram a sentence that contains every letter of the English
    //alphabet at least once.

    public boolean checkIfPangram(String sentence) {
        int[] lower = new int[26];

        int index = 0;

        while (index < sentence.length()) {
            lower[sentence.charAt(index) - 'a']++;
            index++;
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < lower.length; i++) {
            ans.add(lower[i]);
        }

        int min = Collections.min(ans);

        if (min == 0) {
            return false;
        }

        return true;
    }
}
