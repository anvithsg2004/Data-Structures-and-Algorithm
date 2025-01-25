package DSA.Practice.Arrays.Easy;

public class _6_Shuffle_the_Array {

    public int[] shuffle(int[] nums, int n) {

        int[] result = new int[2 * n];

        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];       // Take element from the first half
            result[2 * i + 1] = nums[i + n]; // Take element from the second half
        }

        return result;

    }

    public static void main(String[] args) {

    }
}
