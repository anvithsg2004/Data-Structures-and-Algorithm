package DSA.Practice.Tree.Leetcode_Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _36_Even_Odd_Tree {

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        // Create level-order representation of the tree
        List<List<Integer>> result = fun(root);

        // Iterate through each level and validate even-odd constraints
        for (int i = 0; i < result.size(); i++) {
            List<Integer> level = result.get(i);

            for (int j = 0; j < level.size(); j++) {
                int curr = level.get(j);

                // Even level: Values should be odd and strictly increasing
                if (i % 2 == 0) {
                    if (curr % 2 == 0 || (j > 0 && level.get(j - 1) >= curr)) {
                        return false;
                    }
                }
                // Odd level: Values should be even and strictly decreasing
                else {
                    if (curr % 2 != 0 || (j > 0 && level.get(j - 1) <= curr)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static List<List<Integer>> fun(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Perform level-order traversal and gather values
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
