package DSA.Practice.Tree.Leetcode_Medium;

import java.util.*;

public class _34_Maximum_Level_Sum_of_a_Binary_Tree {

    public int maxLevelSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

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

        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 0;

        for (int i = 0; i < result.size(); i++) {
            int sum = 0;
            for (int j = 0; j < result.get(i).size(); j++) {
                sum += result.get(i).get(j);
            }

            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = i + 1;  // Levels are 1-indexed
            }
        }

        return maxLevel;

    }

    public static void main(String[] args) {

    }
}
