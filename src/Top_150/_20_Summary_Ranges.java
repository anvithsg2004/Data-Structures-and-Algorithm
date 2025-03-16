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
