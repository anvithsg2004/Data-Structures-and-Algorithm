package DSA.Practice.Strings.Leetcode_Easy;

public class _1_Score_of_a_String {

    //The score of a string is computed as follows:
    //For each consecutive pair of characters in the string, calculate the absolute difference between their ASCII values.
    //Sum up all these differences.

    public int scoreOfString(String s) {
        int sum = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            sum = sum + Math.abs((int) (s.charAt(i) - s.charAt(i + 1)));
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
