package DSA.Practice.Arrays.Easy;

public class _2_Build_Array_from_Permutation {

    public int[] buildArray(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            result[i] = nums[nums[i]];

        }

        return result;
    }

    public static void main(String[] args) {

    }
}
