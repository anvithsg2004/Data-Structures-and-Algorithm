package DSA.Practice.Strings.Leetcode_Easy;

public class _10_Split_a_String_in_Balanced_Strings {

    //You are given a string s that consists of only 'L' and 'R'. A balanced string is a string
    //where the number of 'L' and 'R' are equal.
    //Your task is to split the given string into the maximum number of balanced substrings and
    //return the count of these substrings.

    //Input:
    //s = "RLLLLRRRLR"
    //Process:
    //Split: ["RL", "LLLRRR", "LR"]
    //Total Balanced Substrings = 3
    //Output:
    //3

    public int balancedStringSplit(String s) {

        int countR = 0;
        int countL = 0;

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (countL == countR) {
                count++;
                countR = 0;
                countL = 0;
            }

            if (s.charAt(i) == 'R') {
                countR++;
            }

            if (s.charAt(i) == 'L') {
                countL++;
            }

        }

        return count;

    }

    public static void main(String[] args) {

    }
}
