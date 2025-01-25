package DSA.Practice.Tree.Leetcode_Medium;

import java.util.*;

public class _28_Kth_Largest_Sum_in_Binary_Tree {
    public long kthLargestLevelSum(TreeNode root, int k) {

        if (root == null) {
            return 0;
        }

        PriorityQueue<Long> pq = new PriorityQueue<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            long sum = 0;

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                sum = sum + node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

            }

            pq.add(sum);

            if (pq.size() > k) {
                pq.remove();
            }
        }

        if (pq.size() < k) return -1;
        return pq.peek();
    }
}
