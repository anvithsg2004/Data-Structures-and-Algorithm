package DSA.Practice.Tree.Leetcode_Medium;

import java.util.ArrayList;
import java.util.Collections;

public class _18_Count_Good_Nodes_in_Binary_Tree {

    int count1 = 0;

    public int goodNodes2(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return count1;
    }

    public void helper(TreeNode root, int maxSoFar) {
        if (root == null) {
            return;
        }

        if (root.val >= maxSoFar) {
            count1++;
            maxSoFar = root.val;
        }

        helper(root.left, maxSoFar);
        helper(root.right, maxSoFar);
    }


    int count = 0;
    int maxi = Integer.MIN_VALUE;

    public int goodNodes(TreeNode root) {
        helper(root, new ArrayList<>());
        return count;
    }

    //Given a binary tree root, a node X in the tree is named good
    //if in the path from root to X there are no nodes with a value greater than X.
    public void helper(TreeNode root, ArrayList<Integer> arrayList) {
        if (root == null) {
            return;
        }

        arrayList.add(root.val);

        maxi = Collections.max(arrayList);
        if (maxi <= root.val) {
            maxi = root.val;
            count = count + 1;
        }

        helper(root.left, arrayList);
        helper(root.right, arrayList);

        arrayList.remove(arrayList.size() - 1);
    }


    //ChatGPT Method
    private int countGoodNodes(TreeNode node, int maxSoFar) {
        // Base case: if node is null, return 0 (no nodes to count)
        if (node == null) {
            return 0;
        }

        // Initialize count to 0
        int count = 0;

        // If the current node's value is greater than or equal to the max value so far, it's a good node
        if (node.val >= maxSoFar) {
            count = 1;
        }

        // Update the maximum value to be the maximum between maxSoFar and the current node's value
        maxSoFar = Math.max(maxSoFar, node.val);

        // Recursively count good nodes in the left and right subtrees
        count += countGoodNodes(node.left, maxSoFar);
        count += countGoodNodes(node.right, maxSoFar);

        // Return the total count of good nodes
        return count;
    }

    public static void main(String[] args) {

    }
}
