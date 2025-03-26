package DSA.Practice.Strings.Leetcode_Easy;

//The problem "Permutation Difference between Two Strings" is asking you to measure
//how much the order of characters in string t differs from string s by summing up the
//absolute differences of their positions.

//s = "abcde"
//t = "bacde"

//Character	s Position	t Position	Absolute Difference
//  'a'	    0	            1	            `
//  'b'	    1	            0	            `
//  'c'	    2	            2	            `
//  'd'	    3	            3	            `
//  'e'	    4	            4	            `

//Sum Up Differences
//1 + 1 + 0 + 0 + 0 = 2

public class _3_Permutation_Difference_between_Two_Strings {

    public int findPermutationDifference(String s, String t) {
        int[] occS = new int[26];
        int[] occT = new int[26];
        for (int i = 0; i < s.length(); i++) {
            occS[s.charAt(i) - 'a'] = i;
            occT[t.charAt(i) - 'a'] = i;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += Math.abs(occS[i] - occT[i]);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
