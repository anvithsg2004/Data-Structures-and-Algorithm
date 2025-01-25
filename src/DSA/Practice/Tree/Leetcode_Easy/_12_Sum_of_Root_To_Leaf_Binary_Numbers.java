package DSA.Practice.Tree.Leetcode_Easy;

import java.util.ArrayList;

public class _12_Sum_of_Root_To_Leaf_Binary_Numbers {

    public int sumRootToLeaf(TreeNode root) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        findPath(root, new ArrayList<>(), paths);

        int totalSum = 0;

        for (ArrayList<Integer> path : paths) {
            int binary = 0;

            // Convert the path to a binary number
            for (int num : path) {
                binary = binary * 2 + num;  // Construct the binary number
            }

            // Add the binary number (already in decimal form) to total sum
            totalSum += binary;
        }

        return totalSum;
    }

    //It is best to use.
    public void help(TreeNode root, ArrayList<Integer> currPath, ArrayList<ArrayList<Integer>> allPath) {
        if (root == null) {
            return;
        }

        currPath.add(root.val);

        if (root.left == null && root.right == null) {
            allPath.add(new ArrayList<>(currPath));  // add a copy to allPath
        } else {
            help(root.left, currPath, allPath);
            help(root.right, currPath, allPath);
        }

        currPath.remove(currPath.size() - 1);  // backtrack to explore other paths
    }

    public void findPath(TreeNode root, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> allPaths) {
        //Just the base case
        if (root == null) {
            return;
        }

        //Add each Root Node Value
        current.add(root.val);

        //The ArrayList to the new ArrayList when it reaches to the end.
        if (root.left == null && root.right == null) {
            allPaths.add(new ArrayList<>(current));
        }

        //Left
        findPath(root.left, current, allPaths);
        //Right
        findPath(root.right, current, allPaths);

        //Remove the last Node after it come Back
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {

    }
}
