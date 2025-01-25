package DSA.Practice.Tree.Leetcode_Easy;

import java.util.*;

public class _28_Second_Minimum_Node_In_a_Binary_Tree {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        if (map.size() < 2) {
            return -1; // Return -1 if there are fewer than 2 unique values in the tree.
        }

        // Collect and sort the unique values
        List<Integer> arrayList = new ArrayList<>(map.keySet());
        Collections.sort(arrayList);  // Sort to find the second minimum

        // Return the second element (second minimum) from the sorted list
        return arrayList.get(1);
    }

    public void helper(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        helper(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        helper(root.right, map);
    }

    public static void main(String[] args) {

    }
}
