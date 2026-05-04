package neetcode150._2_Two_Pointers;

public class _2_Two_Sum_II_Input_Array_Is_Sorted {
    public int[] twoSum(int[] numbers, int target) {

        int n = numbers.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {

            int currentSum = numbers[left] + numbers[right];

            if (currentSum == target) {
                break;
            } else if (currentSum > target) {
                right--;
            } else {
                left++;
            }

        }

        return new int[]{left + 1, right + 1};

    }
}
