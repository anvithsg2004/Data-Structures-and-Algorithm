package DSA.Practice.Tree.Leetcode_Easy;

import java.util.LinkedList;
import java.util.Queue;

public class _21_Sum_of_Left_Leaves {


    //DFS Method

    //Pre Order Traversal

    public int dfs(TreeNode root) {

        //Root
        if (root == null) {
            return 0;
        }

        int sum = 0;

        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum = sum + root.left.val;
        }

        //Left
        sum = sum + dfs(root.left);
        //Right
        sum = sum + dfs(root.right);

        //Root
        return sum;
    }

    //BFS Method
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;  // If the tree is empty, return 0
        }

        Queue<TreeNode> queue = new LinkedList<>();  // Queue to traverse the tree level by level
        queue.add(root);  // Start with the root node
        int sum = 0;  // To store the sum of left leaves

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();  // Get the current node

            // Check if there is a left child and if it's a leaf node
            if (currentNode.left != null) {
                // Check if the left node is a leaf node
                if (currentNode.left.left == null && currentNode.left.right == null) {
                    sum += currentNode.left.val;  // Add its value to the sum
                }
                queue.add(currentNode.left);  // Add the left child to the queue for further processing
            }

            // Add the right child to the queue if it exists
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        return sum;  // Return the sum of all left leaves
    }


    public static void main(String[] args) {

    }
}
