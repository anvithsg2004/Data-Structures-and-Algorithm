package DSA.Practice.Tree.Leetcode_Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _10_Reverse_Odd_Levels_of_Binary_Tree {

    //BFS
    public TreeNode reverseOddLevels(TreeNode root) {
        helper(root, root, true);
        return root;
    }

    public void helper(TreeNode root1, TreeNode root2, Boolean isOdd) {
        if (root1 == null || root2 == null) {
            return;
        }

        if (isOdd) {
            //Swap the odd level nodes.
            int temp = root1.val;
            root2.val = root1.val;
            root1.val = temp;
        }

        helper(root1.left, root2.right, !isOdd);
        helper(root1.right, root2.left, !isOdd);
    }

    //DFS
    public TreeNode reverseOddLevels1(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> currentLevelNodes = new ArrayList<>();

            // Collect all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevelNodes.add(node);

                // Add left and right children to the queue
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            // If the current level is odd, reverse the values of the nodes at this level
            if (level % 2 == 1) {
                int left = 0, right = currentLevelNodes.size() - 1;
                while (left < right) {
                    int temp = currentLevelNodes.get(left).val;
                    currentLevelNodes.get(left).val = currentLevelNodes.get(right).val;
                    currentLevelNodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }

            level++;
        }

        return root;
    }

    public static void main(String[] args) {

    }
}
