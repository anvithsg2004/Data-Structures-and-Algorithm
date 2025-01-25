package DSA.Practice.Strings.Leetcode_Easy;

public class _10_Split_a_String_in_Balanced_Strings {

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
