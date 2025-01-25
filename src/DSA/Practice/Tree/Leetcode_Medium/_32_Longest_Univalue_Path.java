package DSA.Practice.Tree.Leetcode_Medium;

import java.util.ArrayList;

public class _32_Longest_Univalue_Path {

    //ChatGPT Approach

    public int maxLength = 0;

    public int longestUnivaluePath2(TreeNode root) {
        // Start the recursive search for the longest univalue path
        findUnivaluePath(root);
        return maxLength; // Return the maximum length found
    }

    private int findUnivaluePath(TreeNode node) {
        if (node == null) {
            return 0; // Base case: null node contributes 0 to the path length
        }

        // Recursively find the length of univalue paths for left and right children
        int leftLength = findUnivaluePath(node.left);
        int rightLength = findUnivaluePath(node.right);

        int leftPath = 0, rightPath = 0;

        // Check if left child has the same value as the current node
        if (node.left != null && node.left.val == node.val) {
            leftPath = leftLength + 1; // Increment path length if it continues the univalue
        }

        // Check if the right child has the same value as the current node
        if (node.right != null && node.right.val == node.val) {
            rightPath = rightLength + 1; // Increment path length if it continues the univalue
        }

        // Update the maximum length found so far
        maxLength = Math.max(maxLength, leftPath + rightPath);

        // Return the longest univalue path starting from this node
        return Math.max(leftPath, rightPath);
    }




    //My Approch
    public int longestUnivaluePath(TreeNode root) {

        ArrayList<ArrayList<Integer>> allPath = new ArrayList<>();
        help(root, new ArrayList<>(), allPath);

        int maxi = 0;

        for (int i = 0; i < allPath.size(); i++) {
            int count = 1; // Start with the first node
            int currValue = allPath.get(i).get(0); // Initial node value
            int longestPathForCurrent = 0;

            for (int j = 1; j < allPath.get(i).size(); j++) {
                if (allPath.get(i).get(j) == currValue) {
                    count++; // Continue sequence
                } else {
                    longestPathForCurrent = Math.max(longestPathForCurrent, count);
                    currValue = allPath.get(i).get(j); // Update to new value
                    count = 1; // Restart counting for the new value
                }
            }

            // Final check for the last sequence in the path
            longestPathForCurrent = Math.max(longestPathForCurrent, count);

            // Since we need edges, not nodes, we subtract 1 from the longest sequence
            maxi = Math.max(maxi, longestPathForCurrent - 1);
        }

        return maxi;

    }

    public void help(TreeNode node, ArrayList<Integer> currentPath, ArrayList<ArrayList<Integer>> allPaths) {
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


    public static void main(String[] args) {

    }
}
