package DSA.Dynamic_Programming.Recursion;

import java.util.*;

public class _4_Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        int n = s.length();

        List<List<String>> result = new ArrayList<>();

        backTrack(s, 0, new ArrayList<>(), result, n);

        return result;
    }

    public void backTrack(String s, int start, List<String> current, List<List<String>> result, int n) {

        if (start == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < n; end++) {
            if (isValid(s, start, end)) {
                current.add(s.substring(start, end + 1));
                backTrack(s, end + 1, current, result, n);
                current.remove(current.size() - 1);
            }
        }

    }

    public boolean isValid(String s, int start, int end) {

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

}
