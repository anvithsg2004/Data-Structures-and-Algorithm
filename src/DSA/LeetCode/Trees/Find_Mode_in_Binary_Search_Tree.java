package DSA.LeetCode.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_Mode_in_Binary_Search_Tree {

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> countMap = new HashMap<>();
        inOrder(root, countMap);

        int maxCount = 0;
        for (int count : countMap.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        //Or use this
        // Convert the values collection to an array
        Integer[] counts = countMap.values().toArray(new Integer[0]);
        // Use a normal for loop to find the max count
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
            }
        }

        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                modes.add(entry.getKey());
            }
        }

        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }

        return result;
    }

    private void inOrder(TreeNode root, Map<Integer, Integer> countMap) {
        if (root == null) {
            return;
        }

        inOrder(root.left, countMap);
        countMap.put(root.val, countMap.getOrDefault(root.val, 0) + 1);
        inOrder(root.right, countMap);
    }

    public static void main(String[] args) {

    }
}
