package DSA.Practice.Strings.Leetcode_Easy;

//Question: Maximum Score After Splitting a String
//You are given a binary string s (containing only '0' and '1'). You can split it into two non-empty parts at any position.
//The score of a split is:
//The number of '0' in the left part.
//The number of '1' in the right part.
//Total score = (number of '0's in left) + (number of '1's in right)
//Find the maximum score possible.

//Input
//s = "011101"

//Index i	Character	zeroCount	onesCount	sum
//  0	        '0'	        1	        4	    5
//  1	        '1'	        1	        3	    5
//  2	        '1'	        1	        2	    5
//  3	        '1'	        1	        1	    5
//  4	        '0'	        2	        1	    5

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
