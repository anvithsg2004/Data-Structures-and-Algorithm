package DSA.Practice.Strings.Leetcode_Medium;

public class _16_Check_if_a_Parentheses_String_Can_Be_Valid {
    public boolean canBeValid(String s, String locked) {

        int n = s.length();

        if (n % 2 == 1) {
            //This is of Odd length so false.
            return false;
        }

        if ((s.charAt(0) == ')' && locked.charAt(0) == '1') && (s.charAt(n - 1) == '(' && locked.charAt(n - 1) == '1')) {
            return false;
        }

        

        return true;

    }
}
