package DSA.Practice.Arrays.Easy;

public class _3_Find_Minimum_Operations_to_Make_All_Elements_Divisible_by_Three {

    public int minimumOperations(int[] nums) {

        int n = nums.length;

        int count = 0;

        for (int i = 0; i < n; i++) {

            int reminder = nums[i] % 3;

            if (reminder > 0) {

                count++;

            }

        }

        return count;

    }

    public static void main(String[] args) {

    }
}
