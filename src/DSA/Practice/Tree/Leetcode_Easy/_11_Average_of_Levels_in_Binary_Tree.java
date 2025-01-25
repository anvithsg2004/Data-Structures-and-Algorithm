package DSA.Practice.Tree.Leetcode_Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _11_Average_of_Levels_in_Binary_Tree {

    public List<Double> averageOfLevels(TreeNode root) {
        // List to store the averages of each level
        List<Double> finale = new ArrayList<>();

        if (root == null) {
            return finale;
        }

        // Queue for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Perform level order traversal
        while (!queue.isEmpty()) {
            double finu = 0;  // Sum of values for the current level
            int levelSize = queue.size();  // Number of nodes at the current level

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // Add the current node's value to the sum
                finu = finu + currentNode.val;

                // Check and add the left and right children of the current node to the queue
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Calculate the average for this level and add it to the result
            finale.add(finu / levelSize);
        }

        return finale;
    }

    public static void main(String[] args) {

    }
}
