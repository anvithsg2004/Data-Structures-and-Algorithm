package DSA.Practice.Tree.Leetcode_Easy;

import java.util.*;

public class _25_Find_Mode_in_Binary_Search_Tree {

    public int[] findMode(TreeNode root) {

        if (root == null) {
            return new int[]{0};
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        helper(root, frequencyMap);

        //Highest Frequency
        int maxFrequency = Collections.max(frequencyMap.values());

        // Step 3: Collect all keys (numbers) that have the highest frequency
        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modes.add(entry.getKey());
            }
        }

        // Step 4: Convert the list of modes to an array and return it
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }

        return result;
    }

    public void helper(TreeNode root, Map<Integer, Integer> frequencyMap) {
        if (root == null) {
            return;
        }

        helper(root.left, frequencyMap);
        frequencyMap.put(root.val, frequencyMap.getOrDefault(root.val, 0) + 1);
        helper(root.right, frequencyMap);
    }

    public static void main(String[] args) {

    }
}
