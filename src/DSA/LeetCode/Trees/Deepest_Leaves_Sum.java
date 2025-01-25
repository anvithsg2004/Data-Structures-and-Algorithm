package DSA.LeetCode.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Deepest_Leaves_Sum {

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int sum = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            sum = 0;  // Reset sum for the current level

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;  // Add the node value to sum

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
