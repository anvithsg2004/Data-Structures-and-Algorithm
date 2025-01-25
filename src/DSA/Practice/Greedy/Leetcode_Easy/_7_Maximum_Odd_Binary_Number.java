package DSA.Practice.Greedy.Leetcode_Easy;

public class _7_Maximum_Odd_Binary_Number {
    public static String maximumOddBinaryNumber(String s) {
        int n = s.length();

        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = Character.getNumericValue(s.charAt(i));
        }

        int oneCount = 0;

        for (int i = 0; i < n; i++) {
            if (values[i] == 1) {
                oneCount++;
            }
        }

        int[] result = new int[n];

        if (oneCount >= 1) {
            result[n - 1] = 1;
            oneCount = oneCount - 1;
        }

        for (int i = 0; i < n - 1 && oneCount > 0; i++) {
            result[i] = 1;
            oneCount--;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String num = "0101";
        System.out.println(maximumOddBinaryNumber(num));
    }
}
