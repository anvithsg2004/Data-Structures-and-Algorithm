package DSA.Strings;

public class _16_Largest_odd_number_in_a_string {

    public String largestOddNumber(String num) {

        // Length of the input string
        int n = num.length();

        // Check if the last digit is odd
        if (Integer.parseInt(String.valueOf(num.charAt(n - 1))) % 2 != 0) {
            return num; // If last digit is odd, return the whole string
        }

        // Initialize result as empty
        String result = "";

        // Iterate through the string to find the largest odd number substring
        for (int i = n - 1; i >= 0; i--) {
            // Check if the current digit is odd
            if (Integer.parseInt(String.valueOf(num.charAt(i))) % 2 != 0) {
                result = num.substring(0, i + 1); // Store substring up to and including this odd digit
                break; // Exit the loop once we find the largest odd number
            }
        }

        return result;

    }

    public static void main(String[] args) {

    }
}
