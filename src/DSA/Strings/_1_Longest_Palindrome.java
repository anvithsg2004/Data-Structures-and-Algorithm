package DSA.Strings;

public class _1_Longest_Palindrome {

    public int longestPalindrome(String s) {
        if (s == null) {
            return 0;
        }

        int[] lower = new int[26];
        int[] upper = new int[26];

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) >= 'a') {
                lower[s.charAt(i) - 'a']++;
            } else {
                upper[s.charAt(i) - 'A']++;
            }

        }

        //In this problem the intuition is only the even number of the times the character has repeated.
        //If there is an odd, then reduce it.

        //If you get any odd then add it at the last.

        //count: Total length of the palindrome formed so far.
        //isOdd: A flag to indicate if any character has an odd frequency
        //(to allow one odd character in the center of the palindrome).
        int count = 0;
        int isOdd = 0;

        for (int i = 0; i < 26; i++) {

            if (lower[i] > 0) { // Only process non-zero frequencies for lowercase
                if (lower[i] % 2 == 0) {
                    count += lower[i];
                } else {
                    count += lower[i] - 1;
                    isOdd = 1;
                }
            }

            if (upper[i] > 0) { // Only process non-zero frequencies for uppercase
                if (upper[i] % 2 == 0) {
                    count += upper[i];
                } else {
                    count += upper[i] - 1;
                    isOdd = 1;
                }
            }
        }


        return count + isOdd;
    }

    public static void main(String[] args) {

    }
}
