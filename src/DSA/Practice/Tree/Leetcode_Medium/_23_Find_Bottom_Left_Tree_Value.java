package DSA.Practice.Tree.Leetcode_Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _23_Find_Bottom_Left_Tree_Value {

    //ChatGPT Approach
    //This approach is giving error but a good approach to try.
    public int findBottomLeftValue2(TreeNode root) {
        int[] result = new int[2];
        helper(root, result, 0);
        return result[1];
    }

    public void helper(TreeNode root, int[] result, int level) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (result[0] < level) {
                result[0] = level;
                result[1] = root.val;
            }
        }

        helper(root.left, result, level + 1);
        helper(root.right, result, level + 1);
    }



    //My Approach
    //Use Level order traversal.
    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> result = fun(root);

        return result.get(result.size() - 1).get(0);
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
