package DSA.Tree.Binary_Tree;

import java.util.ArrayList;

public class _4_Max_Path_Sum {

    //maxPathSum and maxPathDown (Maximum Path Sum in Binary Tree)
    public static int maxPathSum(TreeNode root) {
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxValue[0] = maxPathDown(root, maxValue);
        return maxValue[0];
    }

    public static int maxPathDown(TreeNode root, int[] maxValue) {
        if (root == null) {
            return 0;
        }

        //This is to take only positive numbers only.
        int left = Math.max(0, maxPathDown(root.left, maxValue));
        int right = Math.max(0, maxPathDown(root.right, maxValue));

        maxValue[0] = Math.max(maxValue[0], left + right + root.val);

        return Math.max(left, right) + root.val;
    }


    //pathSum and help (Sum of All Paths in a Binary Tree)
    public int pathSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        help(root, new ArrayList<>(), result);

        int maxi = 0;

        for (int i = 0; i < result.size(); i++) {
            int sum = 0;
            for (int j = 0; j < result.get(i).size(); j++) {
                sum = sum + result.get(i).get(j);
            }
            maxi = Math.max(maxi, sum);
        }

        return maxi;
    }

    public void help(TreeNode node, ArrayList<Integer> currentPath, ArrayList<ArrayList<Integer>> allPaths) {
        //Just returns as there is no nodes to go.
        if (node == null) {
            return; // Base case: do nothing for null nodes
        }

        // Add the current node's value to the path
        currentPath.add(node.val);

        // Add the current path to allPaths (this includes paths of all lengths)
        allPaths.add(new ArrayList<>(currentPath));

        // Recur for left and right children
        help(node.left, currentPath, allPaths);
        help(node.right, currentPath, allPaths);

        // Backtrack: remove the current node's value before going back up
        currentPath.remove(currentPath.size() - 1);
    }
}
