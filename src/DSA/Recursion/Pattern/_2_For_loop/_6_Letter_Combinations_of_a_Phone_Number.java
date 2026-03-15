package DSA.Recursion.Pattern._2_For_loop;

import java.util.*;

public class _6_Letter_Combinations_of_a_Phone_Number {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        String[] map = {
                "", "", "abc", "def", "ghi", "jkl",
                "mno", "pqrs", "tuv", "wxyz"
        };

        helper(0, digits, result, map, new StringBuilder());

        return result;

    }

    public void helper(int index, String digit, List<String> result, String[] map, StringBuilder temp) {

        if (index == digit.length()) {
            result.add(temp.toString());
            return;
        }

        String letters = map[digit.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {

            // Choose
            temp.append(ch);

            // Explore
            helper(index + 1, digit, result, map, temp);

            // Undo
            temp.deleteCharAt(temp.length() - 1);

        }

    }

}
