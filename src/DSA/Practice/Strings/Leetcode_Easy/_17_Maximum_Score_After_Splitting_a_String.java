package DSA.Practice.Strings.Leetcode_Easy;

public class _17_Maximum_Score_After_Splitting_a_String {
    public int maxScore(String s) {

        int n = s.length();

        int zeros = 0;
        int ones = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zeros = zeros + 1;
            } else if (s.charAt(i) == '1') {
                ones = ones + 1;
            }
        }

        int sum = Integer.MIN_VALUE;
        int zeroCount = 0;
        int onesCount = ones;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                zeroCount = zeroCount + 1;
                sum = Math.max(sum, zeroCount + onesCount);
            } else if (s.charAt(i) == '1') {
                onesCount = onesCount - 1;
                sum = Math.max(sum, zeroCount + onesCount);
            }
        }


        return sum;

    }
}
