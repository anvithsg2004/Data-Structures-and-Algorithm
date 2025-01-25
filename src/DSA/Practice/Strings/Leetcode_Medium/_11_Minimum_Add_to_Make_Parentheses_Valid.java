package DSA.Practice.Strings.Leetcode_Medium;

public class _11_Minimum_Add_to_Make_Parentheses_Valid {

    public int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                open++;
            }
            if (ch == ')') {
                close++;
            }

        }


        return Math.abs(open - close);
    }

    public static void main(String[] args) {

    }
}
