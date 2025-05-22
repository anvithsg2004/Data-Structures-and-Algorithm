package DSA.Subarrays.Easy;

public class _9_Subtract_the_Product_and_Sum_of_Digits_of_an_Integer {
    public static int subtractProductAndSum(int n) {

        int sum = 0;
        int product = 1;

        String numberToString = "" + n;

        for (int i = 0; i < numberToString.length(); i++) {
            sum = sum + (numberToString.charAt(i) - '0');
            product = product * (numberToString.charAt(i) - '0');
        }

        return product - sum;

    }

    public static void main(String[] args) {

    }
}
