package DSA.Array;

import java.util.Arrays;

public class _15_2_Sum_2_Pointer_Approch {

    public static int[] _2_Sum(int[] array, int target) {
        int n = array.length;
        int left = 0;
        int right = n - 1;

        //This is the easiest one.
        //Here first we sort the array.
        //We keep two pointers in the start and the end.
        Arrays.sort(array);

        while (left < right) {
            int sum = array[left] + array[right];

            //If we get the expected sum, then return the left and right index.
            if (sum == target) {
                return new int[]{left, right};
            }//If the sum is lesser than increase the left to increase the sum.
            else if (sum < target) {
                left++;
            } //If the sum is greater than the target than decrease the right to match the sum.
            else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};

        int target = 3;

        System.out.println("The index are : " + Arrays.toString(_2_Sum(array, target)));
    }
}
