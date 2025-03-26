package DSA.Practice.Strings.Leetcode_Easy;

//Check if One String Swap Can Make Strings Equal
//Given two strings s1 and s2 of equal length, return true if you can make s1 equal to s2
//by swapping exactly one pair of characters in s1. Otherwise, return false.

//Input:
//String s1 = "bank";
//String s2 = "kanb";

//Output:
//true

//Explanation:
//Swapping 'b' and 'k' in "bank" results in "kanb", which is equal to s2.

public class _21_Check_if_One_String_Swap_Can_Make_Strings_Equal {
    public static boolean areAlmostEqual(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        int count = 0;

        for (int i = 0; i < s1.length(); i++) {

            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }

        }

        if (count == 0) {
            return true;
        }

        if (count == 2) {
            return fun(s1, s2);
        }

        return false;

    }

    public static boolean fun(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] s1Char = new char[2];
        char[] s2Char = new char[2];

        int index = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (index >= 2) return false; // More than 2 differences

                s1Char[index] = s1.charAt(i);
                s2Char[index] = s2.charAt(i);
                index++;
            }
        }

        return index == 2 && (s1Char[0] == s2Char[1] && s1Char[1] == s2Char[0]);
    }


    public static void main(String[] args) {
        String s1 = "caa";
        String s2 = "aaz";
        System.out.println(areAlmostEqual(s1, s2));
    }
}
