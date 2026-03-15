package DSA.Recursion.Pattern._4_Palindrome_Partition;

import java.util.*;

public class _4_Palindrome_Partitioning_II {
    public int minCut(String s) {

        int n = s.length();

        List<List<String>> result = new ArrayList<>();

        helper(0, s, result, new ArrayList<>());

        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < result.size(); i++) {

            minCount = Math.min(minCount, result.get(i).size());

        }

        return minCount - 1;

    }

    public void helper(int start, String s, List<List<String>> result, List<String> temp) {

        if (start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int end = start; end < s.length(); end++) {

            if (isPalindrome(s, start, end)) {

                // Choose
                temp.add(s.substring(start, end + 1));

                // Explore
                helper(end + 1, s, result, temp);

                // Undo
                temp.remove(temp.size() - 1);

            }

        }

    }

    public boolean isPalindrome(String s, int start, int end) {

        while (start <= end) {

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;

        }

        return true;

    }
}
