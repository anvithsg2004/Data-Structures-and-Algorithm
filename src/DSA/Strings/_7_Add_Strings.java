package DSA.Strings;

import java.math.BigInteger;

public class _7_Add_Strings {

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
