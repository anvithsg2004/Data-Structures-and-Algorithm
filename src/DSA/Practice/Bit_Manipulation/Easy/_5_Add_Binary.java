package DSA.Practice.Bit_Manipulation.Easy;

public class _5_Add_Binary {

    public String addBinary(String a, String b) {

        int num1 = convertToDecimal(a);
        int num2 = convertToDecimal(b);

        int result = num1 + num2;

        return convertToBinary(result);

    }

    public static String convertToBinary(int n) {
        if (n == 0) {
            return "0";
        }

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

        for (int i = n - 1; i >= 0; i--) {
            if (x.charAt(i) == '1') {
                num = num + power2;
            }
            power2 = power2 * 2;
        }

        return num;

    }

}
