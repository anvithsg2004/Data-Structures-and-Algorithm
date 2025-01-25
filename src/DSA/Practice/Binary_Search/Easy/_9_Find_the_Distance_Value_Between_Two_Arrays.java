package DSA.Practice.Binary_Search.Easy;

import java.util.Arrays;

public class _9_Find_the_Distance_Value_Between_Two_Arrays {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        Arrays.sort(arr1);
        int n1 = arr1.length;
        Arrays.sort(arr2);
        int n2 = arr2.length;

        int count = 0;

        for (int i = 0; i < n1; i++) {

            int low = 0;
            int high = n2 - 1;

            boolean notSatisfy = true;

            while (low <= high) {

                int mid = (low + high) / 2;

                int differ = Math.abs(arr2[mid] - arr1[i]);

                if (differ <= d) {
                    notSatisfy = false;
                    break;
                } else if (arr2[mid] < arr1[i]) {
                    //Important Condition
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }

            if (notSatisfy == true) {
                count++;
            }

        }

        return count;

    }

    public static void main(String[] args) {

    }
}
