package DSA.Bit_Manipulation;

public class _1_BinaryConversion_1s_And_2s {
    public static String convertToBinary(int n) {
        if (n == 0) {
            return "0"; // Handle the edge case when n is 0
        }

        //It is just simply dividing the number and storing the remainder.
        //At last reversing it and returning it.
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            if (n % 2 == 1) {
                result.append('1');
            } else {
                result.append('0');
            }
            n = n / 2;
        }

        return result.reverse().toString();
    }

    public static int convertToDecimal(String x) {

        int n = x.length();

        int power2 = 1;

        int num = 0;

        //Wherever I get '1' then multiply it by the power of 2 where the index is there.
        for (int i = n - 1; i >= 0; i--) {
            if (x.charAt(i) == '1') {
                num = num + power2;
            }
            power2 = power2 * 2;
        }

        return num;

    }
}
