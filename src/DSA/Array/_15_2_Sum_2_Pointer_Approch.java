package DSA.Array;

import java.util.Arrays;

public class _15_2_Sum_2_Pointer_Approch {

    public static int[] _2_Sum(int[] array, int target) {
        int n = array.length;
        int left = 0;
        int right = n - 1;

        Arrays.sort(array);

        while (left < right) {
            int sum = array[left] + array[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
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
