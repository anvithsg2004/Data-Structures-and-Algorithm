package DSA.Subarrays.Easy;

public class _10_Remove_Palindromic_Subsequences {
    public static int removePalindromeSub(String s) {

        boolean isPalindrome = true;

        int n = s.length();

        int left = 0;
        int right = n - 1;

        while (left < n && right > 0) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            return 1;
        }

        return 2;

    }
}
