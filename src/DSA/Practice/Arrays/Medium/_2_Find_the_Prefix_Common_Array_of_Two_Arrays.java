package DSA.Practice.Arrays.Medium;

import java.util.Arrays;
import java.util.HashSet;

public class _2_Find_the_Prefix_Common_Array_of_Two_Arrays {
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> numA = new HashSet<>();
        HashSet<Integer> numB = new HashSet<>();

        int n = A.length;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            numA.add(A[i]);
            numB.add(B[i]);

            int count1 = 0;
            int count2 = 0;

            for (int j = 0; j <= i; j++) {

                if (numA.contains(B[j])) {
                    count1++;
                }

            }

            for (int j = 0; j <= i; j++) {

                if (numB.contains(A[j])) {
                    count2++;
                }

            }

            result[i] = Math.min(count1, count2);

        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 1};
        int[] B = {3, 1, 2};
        System.out.println(Arrays.toString(findThePrefixCommonArray(A, B)));
    }

}
