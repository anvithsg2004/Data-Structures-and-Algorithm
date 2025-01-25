package DSA.LeetCode.Arrays;

import java.util.*;

public class Sort_Array_by_Increasing_Frequency {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int element : nums) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());

        // Sort the list based on frequency and then by value
        entryList.sort((entry1, entry2) -> {
            int freqCompare = entry1.getValue().compareTo(entry2.getValue());
            if (freqCompare == 0) {
                return entry2.getKey().compareTo(entry1.getKey());
            } else {
                return freqCompare;
            }
        });

        // Create a result list to store the sorted elements
        List<Integer> result = new ArrayList<>();

        // Iterate through the sorted map and add elements to the result list
        for (Map.Entry<Integer, Integer> entry : entryList) {
            for (int i = 0; i < entry.getValue(); i++) {
                result.add(entry.getKey());
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = result.get(i);
        }

        return nums;
    }

    public static void main(String[] args) {

    }
}
