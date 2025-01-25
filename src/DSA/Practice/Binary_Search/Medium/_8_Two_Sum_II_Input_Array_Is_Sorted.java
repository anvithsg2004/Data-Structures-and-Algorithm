package DSA.Practice.Binary_Search.Medium;

public class _8_Two_Sum_II_Input_Array_Is_Sorted {

    public int[] twoSum(int[] numbers, int target) {

        int n = numbers.length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {

            if (numbers[low] + numbers[high] == target) {

                return new int[]{low + 1, high + 1};

            } else if (numbers[low] + numbers[high] >= target) {

                high--;

            } else if (numbers[low] + numbers[high] <= target) {

                low++;

            }

        }

        return new int[]{-1, -1};

    }

    public static void main(String[] args) {

    }
}
