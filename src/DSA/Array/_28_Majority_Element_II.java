package DSA.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _28_Majority_Element_II {

    //Optimal Solution
    public List<Integer> majorityElement2(int[] nums) {

        int n = nums.length;

        int count1 = 0;
        int count2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            if (count1 == 0 && ele2 != nums[i]) {
                count1 = 1;
                ele1 = nums[i];
            } else if (count2 == 0 && ele1 != nums[i]) {
                count2 = 1;
                ele2 = nums[i];
            } else if (nums[i] == ele1) {
                count1 = count1 + 1;
            } else if (nums[i] == ele2) {
                count2 = count2 + 1;
            } else {
                count1 = count1 - 1;
                count2 = count2 - 1;
            }

        }

        // Second pass: Verify the counts of ele1 and ele2
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == ele1) count1++;
            else if (num == ele2) count2++;
        }

        // Add elements to result if they appear more than n/3 times
        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) result.add(ele1);
        if (count2 > n / 3) result.add(ele2);

        return result;
    }


    //Better Solution
    public List<Integer> majorityElement(int[] nums) {

        // Get the length of the nums array
        int n = nums.length;

        // Initialize the result list to store elements that appear more than n/3 times
        List<Integer> result = new ArrayList<>();

        // HashMap to store each element and its frequency
        HashMap<Integer, Integer> mpp = new HashMap<>();

        // Calculate the minimum frequency an element must have to be added to the result
        int mini = (n / 3) + 1;

        // Iterate through each element in the nums array
        for (int i = 0; i < n; i++) {
            // Update the frequency of nums[i] in the HashMap
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);

            // Check if nums[i] has reached the minimum required frequency
            if (mpp.get(nums[i]) == mini) {
                // Add nums[i] to the result list as it meets the required frequency
                result.add(nums[i]);
            }

            // If we've already found two elements that meet the criteria, we can stop
            if (result.size() == 2) {
                break;
            }
        }

        // Return the list of elements that appear more than n/3 times
        return result;

    }

    public static void main(String[] args) {

    }
}
