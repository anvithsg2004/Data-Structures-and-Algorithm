package DSA.Recursion.Pattern._4_Palindrome_Partition;

import java.util.*;

public class _3_Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();

        List<List<String>> result = new ArrayList<>();

        helper(0, s, wordDict, result, new ArrayList<>());

        return !result.isEmpty();

    }

    public void helper(int start, String s, List<String> wordDict, List<List<String>> result, List<String> temp) {

        if (start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int end = start; end < s.length(); end++) {

            if (isValid(s, start, end, wordDict)) {

                // Choose
                temp.add(s.substring(start, end + 1));

                // Explore
                helper(end + 1, s, wordDict, result, temp);

                // Undo
                temp.remove(temp.size() - 1);

            }

        }

    }

    public boolean isValid(String s, int start, int end, List<String> wordDict) {

        String part = s.substring(start, end + 1);

        for (String string : wordDict) {

            if (part.equals(string)) {
                return true;
            }

        }

        return false;

    }
}
