package Top_150;

//💬 Problem Summary:
//Given a sorted array of unique integers, group them into ranges:
//If numbers are consecutive → "start->end"
//If only one number → "start"

//✅ Approach:
//Traverse the array.
//Use two pointers: start and end of each range.
//When the current number is not consecutive with the previous, store the previous range, and start a new range.
//At the end, don’t forget to store the last range.

//🧩 Problem Explained:
//You are given a sorted array of unique integers.
//You need to group consecutive numbers into ranges.

//📦 Example Input:
//nums = [0, 1, 2, 4, 5, 7]
//✅ Expected Output:
//["0->2", "4->5", "7"]

import java.util.ArrayList;
import java.util.List;

//Loop through array:
//i = 1
//nums[1] = 1, nums[0] + 1 = 1 → Consecutive, continue.
//i = 2
//nums[2] = 2, nums[1] + 1 = 2 → Consecutive, continue.
//i = 3
//nums[3] = 4, nums[2] + 1 = 3 ≠ 4 → Not consecutive
//Time to save range from start = 0 to nums[2] = 2
//Since start != nums[2], add "0->2" to result.
//result = ["0->2"]
//Start new range: start = nums[3] = 4
//i = 4
//nums[4] = 5, nums[3] + 1 = 5 → Consecutive, continue.
//i = 5
//nums[5] = 7, nums[4] + 1 = 6 ≠ 7 → Not consecutive
//Save range from start = 4 to nums[4] = 5
//Since start != nums[4], add "4->5" to result.
//result = ["0->2", "4->5"]
//Start new range: start = nums[5] = 7

//After Loop: Add final range
//Loop is done, add last range from start = 7 to nums[5] = 7
//Since start == nums[5], it's a single number → add "7"
//result = ["0->2", "4->5", "7"]

public class _20_Summary_Ranges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;

        int start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                // Range ends at nums[i - 1]
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + nums[i - 1]);
                }
                start = nums[i];  // Start new range
            }
        }

        // Add the last range
        if (start == nums[nums.length - 1]) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + nums[nums.length - 1]);
        }

        return result;
    }
}
