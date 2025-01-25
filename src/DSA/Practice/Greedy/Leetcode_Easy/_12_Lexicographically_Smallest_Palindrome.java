package DSA.Practice.Greedy.Leetcode_Easy;

//This is how lexicographical order works, treating uppercase letters as smaller than lowercase ones.
public class _12_Lexicographically_Smallest_Palindrome {

    //My Solution
    public String makeSmallestPalindrome(String s) {

        StringBuilder changing = new StringBuilder(s);

        int left = 0;
        int right = s.length() - 1;

        int count = 0;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                if (s.charAt(left) > s.charAt(right)) {
                    changing.setCharAt(left, s.charAt(right));
                } else {
                    changing.setCharAt(right, s.charAt(left));
                }
                count++;
            }

            left++;
            right--;

        }

        return changing.toString();

    }

    //OG Solution
    public String makeSmallestPalindrome2(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (chars[i] != chars[j]) {
                chars[i] = chars[j] = (char) Math.min(chars[i], chars[j]);
            }
            i++;
            j--;
        }

        return new String(chars);
    }
}
