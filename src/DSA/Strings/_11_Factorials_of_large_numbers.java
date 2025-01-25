package DSA.Strings;

import java.math.BigInteger;
import java.util.ArrayList;

public class _11_Factorials_of_large_numbers {

    public ArrayList<Integer> factorial(int n) {
        BigInteger fact = BigInteger.ONE;  // Using BigInteger to handle large factorials

        // Calculate factorial using BigInteger
        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        // Convert the result to a string to store digits
        String result = fact.toString();

        // Store each digit of the result in an ArrayList
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < result.length(); i++) {
            answer.add(Character.getNumericValue(result.charAt(i)));
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
