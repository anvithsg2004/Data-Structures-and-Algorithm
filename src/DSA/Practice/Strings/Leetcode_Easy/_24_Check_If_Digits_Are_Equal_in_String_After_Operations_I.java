package DSA.Practice.Strings.Leetcode_Easy;

//Question: Check If Digits Are Equal in String After Operations
//Given a string of digits, repeatedly perform the following operation until the string has only two digits left:
//Replace each pair of adjacent digits with their sum modulo 10.
//If the two remaining digits are equal, return true, otherwise return false.

//Input:
//String s = "3902";
//Output:
//true
//Explanation:
//Initial: "3902"
//Step 1: ((3+9)%10, (9+0)%10, (0+2)%10) → "291"
//Step 2: ((2+9)%10, (9+1)%10) → "03"
//Step 3: ((0+3)%10) → "3"
//Since there is only one digit left, we cannot compare two digits, so the function returns false.

//Input:
//String s = "555";
//Output:
//true
//Explanation:
//Initial: "555"
//Step 1: ((5+5)%10, (5+5)%10) → "00"
//The last two digits are equal, so return true.

public class _24_Check_If_Digits_Are_Equal_in_String_After_Operations_I {

    public static boolean hasSameDigits(String s) {

        int n = s.length();

        if (n == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return true;
            } else {
                return false;
            }
        }

        String changing = s;

        while (changing.length() != 2) {
            changing = helper(changing);
            System.out.println(changing);
        }

        if (changing.charAt(0) == changing.charAt(1)) {
            return true;
        }

        return false;

    }

    public static String helper(String s) {

        int n = s.length();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n - 1; i++) {

            stringBuilder.append((Integer.parseInt(String.valueOf(s.charAt(i))) + Integer.parseInt(String.valueOf(s.charAt(i + 1)))) % 10);

        }

        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        String s = "3902";
        hasSameDigits(s);
    }

}
