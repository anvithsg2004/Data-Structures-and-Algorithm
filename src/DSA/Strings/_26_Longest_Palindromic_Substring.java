package DSA.Strings;

public class _26_Longest_Palindromic_Substring {

    //s = "babad"
    //"bab" // (or "aba" is also valid)

    //We need to find the longest palindromic substring (LPS).
    //A palindrome reads the same forward and backward.
    //We check for palindromes centered at each character (both odd and even length).

    public String longestPalindrome(String s) {

        int n = s.length();

        if (n == 0) {
            return "";
        }

        if (n == 1) {
            return s;
        }

        String LPS = "";

        for (int i = 1; i < s.length(); i++) {

            //This is for Odd Length Palindrome.
            int low = i;
            int high = i;

            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }

            String palindrome = s.substring(low + 1, high);

            if (palindrome.length() > LPS.length()) {
                LPS = palindrome;
            }

            //This is for Even Length Palindrome.
            low = i - 1;
            high = i;

            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }


            palindrome = s.substring(low + 1, high);

            if (palindrome.length() > LPS.length()) {
                LPS = palindrome;
            }

        }

        return LPS;

    }
}
