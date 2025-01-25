package DSA.Practice.Greedy.Leetcode_Easy;

public class _2_Valid_Palindrome {
    public boolean isPalindrome(String s) {

        String lowerString = s.toLowerCase();

        int n = lowerString.length();

        StringBuilder newString = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = lowerString.charAt(i);
            if (('a' <= c && c <= 'z') || ('0' <= c && c <= '9')) {
                newString.append(c);
            }
        }

        System.out.println(newString);

        int left = 0;
        int right = newString.length();

        while (left < right) {

            if (newString.charAt(left) == newString.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }

        }

        return true;

    }
}
