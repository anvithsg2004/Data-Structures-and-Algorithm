package DSA.Practice.Strings.Leetcode_Easy;

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
