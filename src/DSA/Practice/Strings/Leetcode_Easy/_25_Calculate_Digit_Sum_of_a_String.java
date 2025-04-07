package DSA.Practice.Strings.Leetcode_Easy;

public class _25_Calculate_Digit_Sum_of_a_String {
    public String digitSum(String s, int k) {

        StringBuilder result = new StringBuilder(s);

        while (result.length() > k) {
            result = new StringBuilder(fun(result, k));
        }

        return result.toString();

    }

    public StringBuilder fun(StringBuilder s, int k) {

        int SLenght = s.length();

        StringBuilder newString = new StringBuilder();

        for (int i = 0; i < SLenght; i += k) {
            // Ensure substring does not exceed bounds
            int end = Math.min(i + k, SLenght);
            String subString = s.substring(i, end);

            // Sum of digits
            int sum = 0;
            for (char c : subString.toCharArray()) {
                sum += c - '0'; // Convert char to digit
            }

            newString.append(sum);
        }

        return newString;

    }

    public static void main(String[] args) {
        _25_Calculate_Digit_Sum_of_a_String solution = new _25_Calculate_Digit_Sum_of_a_String();

        // Test Case 1
        String s1 = "11111222223";
        int k1 = 3;
        System.out.println("Output for s = \"" + s1 + "\", k = " + k1 + ": " + solution.digitSum(s1, k1));

        // Test Case 2
//            String s2 = "00000000";
//            int k2 = 3;
//            System.out.println("Output for s = \"" + s2 + "\", k = " + k2 + ": " + solution.digitSum(s2, k2));
    }
}
