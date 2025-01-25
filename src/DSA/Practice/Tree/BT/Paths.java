package DSA.Practice.Tree.BT;

import DSA.Practice.Tree.Leetcode_Medium.TreeNode;

import java.util.ArrayList;

public class Paths {

    //It will take all the paths, permutations and all.
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


    //Only from the root to leaf.
    public void help2(TreeNode root, ArrayList<Integer> currPath, ArrayList<ArrayList<Integer>> allPath) {
        if (root == null) {
            return;
        }

        currPath.add(root.val);

        if (root.left == null && root.right == null) {
            allPath.add(new ArrayList<>(currPath));  // add a copy to allPath
        } else {
            help2(root.left, currPath, allPath);
            help2(root.right, currPath, allPath);
        }

        currPath.remove(currPath.size() - 1);  // backtrack to explore other paths
    }

    public static void main(String[] args) {
        // 1. Construct a sample binary tree
        // Example Tree:
        //        1
        //       / \
        //      2   3
        //     /
        //    4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        // 2. Initialize the Paths class
        Paths pathFinder = new Paths();

        // 3. Test the `help` method (all root-to-node paths)
        ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();
        ArrayList<Integer> currentPath = new ArrayList<>();
        pathFinder.help(root, currentPath, allPaths);
        System.out.println("All root-to-node paths: " + allPaths);

        // 4. Test the `help2` method (only root-to-leaf paths)
        ArrayList<ArrayList<Integer>> allLeafPaths = new ArrayList<>();
        ArrayList<Integer> currentLeafPath = new ArrayList<>();
        pathFinder.help2(root, currentLeafPath, allLeafPaths);
        System.out.println("Root-to-leaf paths: " + allLeafPaths);
    }
}
