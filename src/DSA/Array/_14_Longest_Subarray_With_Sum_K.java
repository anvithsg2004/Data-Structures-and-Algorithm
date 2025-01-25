package DSA.Array;

import java.util.Scanner;

public class _14_Longest_Subarray_With_Sum_K {

    public static int longest(int[] array, int s) {
        int n = array.length;
        int length = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k ++) {
                    sum = sum + array[k];
                }
                if (sum == s) {
                    length = Math.max(length, j - i + 1);
                }
            }
        }

        return length;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,1,1,1,1,4,2,3};

        System.out.println("Enter the sum needed : ");
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        System.out.println("The longest subarray is : " + longest(array, sum));
    }
}
