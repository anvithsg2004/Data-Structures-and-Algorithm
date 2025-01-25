package DSA.Practice.Greedy.Leetcode_Easy;

public class _3_Valid_Palindrome_II {

    public boolean validPalindrome(String s) {

        int n = s.length();

        int left = 0;
        int right = n - 1;

        while (left < right) {

            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }

        }

        return true;

    }

    public boolean isPalindrome(String s, int left, int right) {

        while (left <= right) {

            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }

        }

        return true;

    }
}
