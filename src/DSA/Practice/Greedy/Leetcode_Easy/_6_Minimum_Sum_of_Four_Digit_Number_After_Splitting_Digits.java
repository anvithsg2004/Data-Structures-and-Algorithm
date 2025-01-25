package DSA.Practice.Greedy.Leetcode_Easy;

import java.util.Arrays;

public class _6_Minimum_Sum_of_Four_Digit_Number_After_Splitting_Digits {

    //Nice solution.
    public static int minimumSum(int num) {

        String numStr = String.valueOf(num);

        char[] result = new char[numStr.length()];

        for (int i = 0; i < numStr.length(); i++) {
            result[i] = numStr.charAt(i);
        }

        Arrays.sort(result);

        String first = String.valueOf(result[0]);
        String second = String.valueOf(result[1]);
        String third = String.valueOf(result[2]);
        String four = String.valueOf(result[3]);

        String firstNum = first + four;
        String secondNum = second + third;
        System.out.println(secondNum);

        return Integer.parseInt(firstNum) + Integer.parseInt(secondNum);

    }

    //This is the OG.
    public int minimumSum2(int num) {
        int[] arr = new int[4];
        int i = 0;
        while (num > 0) {
            arr[i++] = num % 10;
            num /= 10;
        }
        Arrays.sort(arr);
        int x = arr[0] * 10 + arr[2];
        int y = arr[1] * 10 + arr[3];
        return x + y;
    }

    public static void main(String[] args) {
        System.out.println(minimumSum(2932));
    }
}
