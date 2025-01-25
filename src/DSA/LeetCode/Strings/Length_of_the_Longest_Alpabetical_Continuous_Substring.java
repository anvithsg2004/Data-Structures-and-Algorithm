package DSA.LeetCode.Strings;

public class Length_of_the_Longest_Alpabetical_Continuous_Substring {

    public int longestContinuousSubstring(String s) {
        int maxLen = 1;
        int left = 0, right = 1;

        while (right < s.length()) {
            if (s.charAt(right - 1) + 1 != s.charAt(right)) {
                maxLen = Math.max(maxLen, right - left);
                left = right;
            }
            right++;
        }
        return Math.max(maxLen, right - left);
    }

    public static void main(String[] args) {

    }
}
