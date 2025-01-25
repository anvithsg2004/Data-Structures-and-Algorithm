package DSA.Practice.Tree.Leetcode_Medium;

import DSA.Practice.Tree.BFS.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _3_Deepest_Leaves_Sum {

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<List<Integer>> result = fun(root);

        List<Integer> list = result.get(result.size() - 1);

        int sum = 0;
        for (int num : list) {
            sum = sum + num;
        }

        return sum;
    }

    public static List<List<Integer>> fun(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

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

        return result;
    }

    public static void main(String[] args) {

    }
}
