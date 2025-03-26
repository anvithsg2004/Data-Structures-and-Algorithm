package DSA.Practice.Strings.Leetcode_Easy;

import java.util.ArrayList;
import java.util.List;

//You are given:
//An array of words (words[]).
//A character (x).
//👉 Your task is to find all indices where x appears in any word in the array.

//words = ["apple", "banana", "cherry", "date"];
//x = 'a';

//Step-by-Step Execution
//"apple" → contains 'a' ✅ → index 0 added.
//"banana" → contains 'a' ✅ → index 1 added.
//"cherry" → does not contain 'a' ❌.
//"date" → contains 'a' ✅ → index 3 added.

//Output
//[0, 1, 3]

public class _5_Find_Words_Containing_Character {

    public List<Integer> findWordsContaining(String[] words, char x) {

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            int count = 0;
            for (int j = 0; j < words[i].length(); j++) {

                if (x == words[i].charAt(j)) {
                    result.add(i);
                    break;
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {

    }
}
