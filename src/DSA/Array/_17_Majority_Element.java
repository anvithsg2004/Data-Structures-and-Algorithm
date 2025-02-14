package DSA.Array;

import java.util.HashMap;
import java.util.Map;

public class _17_Majority_Element {

    //Moore's Voting Algorithm
    public int majorityElement2(int[] nums) {

        int n = nums.length;
        int count = 0;
        int ele = 0;

        for (int i = 0; i < n; i++) {

            //If the count is '0' then assign a new element and increase the count.
            if (count == 0) {
                count = 1;
                ele = nums[i];
            }// If we encounter the same element 'ele' then increase the count.
            else if (ele == nums[i]) {
                count++;
            } else {
                //If we encounter any different element, then decrease the count.
                count--;
            }

        }

        int count1 = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] == ele) {

                count1++;

            }

        }

        if (count1 > (n / 2)) {
            return ele;
        }

        return -1;

    }

    //Hashing
    public int majorityElement(int[] nums) {

        int n = nums.length;

        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < n; i++) {

            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);

        }

        for (Map.Entry<Integer, Integer> it : frequency.entrySet()) {

            if (it.getValue() > (n / 2)) {

                return it.getKey();

            }

        }

        return -1;

    }
}
