package DSA.Sliding_Window;

public class _6_Count_Number_of_Nice_Subarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        return help(nums, k) - help(nums, k - 1);
    }

    public int help(int[] nums, int k) {

        if (k < 0) {
            return 0;
        }

        int n = nums.length;

        int i = 0;
        int j = 0;

        int currentOddNumber = 0;

        int count = 0;

        while (j < n) {

            if (nums[j] % 2 == 1) {
                currentOddNumber++;
            }

            while (currentOddNumber > k) {
                if (nums[i] % 2 == 1) {
                    currentOddNumber--;
                }
                i++;
            }

            count = count + (j - i + 1);
            j++;

        }

        return count;

    }
}
