package DSA.Recursion.Pattern._4_Palindrome_Partition;

import java.util.*;

public class _2_Restore_IP_Addresses {
    public List<String> restoreIpAddresses(String s) {

        int n = s.length();

        List<String> result = new ArrayList<>();

        helper(0, s, result, new StringBuilder(), 4);

        return result;

    }

    public void helper(int start, String s, List<String> result, StringBuilder temp, int count) {

        if (start == s.length() && count == 0) {
            result.add(temp.substring(0, temp.length() - 1));
            return;
        }

        for (int end = start; end < s.length() && end < start + 3; end++) {

            if (isValid(s, start, end)) {

                int len = temp.length();

                // Choose
                temp.append(s.substring(start, end + 1)).append('.');

                // Explore
                helper(end + 1, s, result, temp, count - 1);

                // Undo
                temp.setLength(len);

            }

        }

    }

    public boolean isValid(String s, int start, int end) {

        int n = s.length();

        String num = s.substring(start, end + 1);

        if (num.length() > 1 && num.charAt(0) == '0') return false;

        int value = Integer.parseInt(num);

        return value >= 0 && value <= 255;

    }
}
