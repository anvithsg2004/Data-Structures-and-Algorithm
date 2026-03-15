package DSA.Recursion.Pattern._3_Permutation;

import java.util.*;

public class _3_Permutation_in_String {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[s1.length()];
        helper(s1, used, result, new StringBuilder());

        List<String> allSubString = new ArrayList<>();
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            allSubString.add(s2.substring(i, i + s1.length()));
        }

        for (String s : result) {

            for (String string : allSubString) {

                if (s.equals(string)) {
                    return true;
                }

            }

        }

        return false;
    }

    // This is for s1
    public void helper(String s, boolean[] used, List<String> result, StringBuilder temp) {

        if (temp.length() == s.length()) {
            result.add(temp.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {

            if (used[i]) {
                continue;
            }

            // Choose
            used[i] = true;
            temp.append(s.charAt(i));

            // Explore
            helper(s, used, result, temp);

            // Undo
            used[i] = false;
            temp.deleteCharAt(temp.length() - 1);

        }

    }

}
