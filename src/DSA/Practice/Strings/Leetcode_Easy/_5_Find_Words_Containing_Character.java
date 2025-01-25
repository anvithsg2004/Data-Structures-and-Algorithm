package DSA.Practice.Strings.Leetcode_Easy;

import java.util.ArrayList;
import java.util.List;

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
