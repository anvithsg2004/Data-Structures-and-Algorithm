package DSA.Strings;

//Input: s = "42"
//Output: 42

//Input: s = "   -42"
//Output: -42
//Explanation: Leading whitespaces are ignored, '-' sign is detected.

//Input: s = "4193 with words"
//Output: 4193
//Explanation: The number stops at the first non-digit character.

//Input: s = "words and 987"
//Output: 0
//Explanation: No valid number is found at the start.

//Input: s = "-91283472332"
//Output: -2147483648
//Explanation: Clamped to Integer.MIN_VALUE.

//Character	ASCII Value	'Character' - '0' (48)	Integer Value
//'0'	48	48 - 48 = 0	0
//'1'	49	49 - 48 = 1	1
//'2'	50	50 - 48 = 2	2
//'9'	57	57 - 48 = 9	9

//Convert a numeric string to number.
//String str = "1234";
//int num = Integer.parseInt(str);
//System.out.println(num); // Output: 1234

//Convert a number to a string
//int num = 1234;
//String str = String.valueOf(num);
//System.out.println(str); // Output: "1234"

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
            int digit = s.charAt(i) - '0';

            if (digit < 0 || digit > 9) break;

            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 + digit;
        }

        if (isNegative == true) {
            return -result;
        }

        return result;

    }
}
