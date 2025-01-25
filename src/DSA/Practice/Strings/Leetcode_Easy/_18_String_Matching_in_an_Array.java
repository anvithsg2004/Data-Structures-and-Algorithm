package DSA.Practice.Strings.Leetcode_Easy;

import java.util.ArrayList;
import java.util.List;

public class _18_String_Matching_in_an_Array {
    public List<String> stringMatching(String[] words) {

        List<String> result = new ArrayList<>();

        int n = words.length;

        for (int i = 0; i < n; i++) {

            if (doesContains(words[i], words)) {
                result.add(words[i]);
            }

        }

        return result;

    }

    public boolean doesContains(String check, String[] words) {

        int n = words.length;

        for (int i = 0; i < n; i++) {

            if (words[i].contains(check) && check != words[i]) {
                return true;
            }

        }

        return false;
    }
}
