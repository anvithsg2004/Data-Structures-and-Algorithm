package DSA.Practice.Strings.Leetcode_Easy;

import java.util.ArrayList;
import java.util.List;

//String Matching in an Array
//You are given an array of strings words. A string is a substring of another string if it appears in that string.
//Return all words in words that are a substring of another word in words.
//The order of the result should match the order in the original array.

//Input:
//String[] words = {"mass", "as", "hero", "superhero"};

//Explanation:
//"as" is a substring of "mass".
//"hero" is a substring of "superhero".
//"mass" and "superhero" are not substrings of any other word.

//Output:
//["as", "hero"]

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

            if (words[i].contains(check) && !check.equals(words[i])) {
                return true;
            }

        }

        return false;
    }
}
