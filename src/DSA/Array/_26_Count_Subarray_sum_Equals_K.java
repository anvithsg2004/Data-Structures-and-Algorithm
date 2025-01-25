package DSA.Array;

public class _26_Count_Subarray_sum_Equals_K {

    //Optimal Solution
    //See Video


    //Better Solution
    public int subarraySum(int[] nums, int k) {

        int n = nums.length;
        int count = 0;

        //Just Generating all the Sub-Arrays and checking with the "k"
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + nums[j];


                if (sum == k) {
                    count++;
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {

    }
}
