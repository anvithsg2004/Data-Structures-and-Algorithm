package DSA.Strings;

public class _23_String_to_Integer_atoi {

    public int myAtoi(String s) {

        s = s.trim();

        if (s.length() == 0) return 0;

        int result = 0;

        boolean isNegative = false;

        int i = 0;

        if (s.charAt(0) == '-') {
            isNegative = true;
            i++; // Skip the '-' sign
        } else if (s.charAt(0) == '+') {
            i++; // Skip the '+' sign
        }

        for (; i < s.length(); i++) {
            int middle = s.charAt(i) - '0';

            // Break if it's not a digit
            if (middle < 0 || middle > 9) {
                break;
            }

            // Check for overflow before multiplying result by 10
            if (result > (Integer.MAX_VALUE - middle) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = (result * 10) + middle;
        }

        if (isNegative == true) {
            return -result;
        }

        return result;

    }

    public static void main(String[] args) {

    }
}
