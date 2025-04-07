package DSA.Strings;

import java.math.BigInteger;

public class _7_Add_Strings {

    public static String addStrings3(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 10; // Get new carry
            result.append((char) ('0' + (sum % 10))); // Append last digit

            i--;
            j--;
        }

        return result.reverse().toString();
    }

    //To handle Big Numbers
    public String addStrings2(String num1, String num2) {
        BigInteger add1 = new BigInteger(num1);
        BigInteger add2 = new BigInteger(num2);

        // Add the two BigIntegers
        BigInteger sum = add1.add(add2);

        // Convert the result back to string
        return sum.toString();
    }

    public String addStrings(String num1, String num2) {
        int add1 = Integer.parseInt(num1);
        int add2 = Integer.parseInt(num2);

        int add = add1 + add2;

        String ans = Integer.toString(add);

        return ans;
    }

    public static void main(String[] args) {

    }
}
