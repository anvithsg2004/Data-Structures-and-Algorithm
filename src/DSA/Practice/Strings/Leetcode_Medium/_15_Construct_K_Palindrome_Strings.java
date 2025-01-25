package DSA.Practice.Strings.Leetcode_Medium;

import java.util.Arrays;

public class _15_Construct_K_Palindrome_Strings {
    public static boolean canConstruct(String s, int k) {

        //https://chatgpt.com/share/6781f0ea-1b3c-800c-9645-535e23589814
        //See this link, you will get the correct idea.

        //First count the frequencies.
        int[] frequency = new int[26];

        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }

        System.out.println(Arrays.toString(frequency));

        int countOdd = 0;

        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] % 2 == 1) {
                countOdd++;
            }
        }

        System.out.println(countOdd);

        if (s.length() < k) {
            return false;
        }

        if (countOdd <= k) {
            return true;
        } else {
            return false;
        }


    }

    public static void main(String[] args) {
        String s = "annabelle";
        int k = 2;
        System.out.println(canConstruct(s, k));
    }
}
