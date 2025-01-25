package DSA.Practice.Tree.BFS;

import java.util.*;

public class Zig_Zag_Level_Traversal {

    public static List<List<Integer>> fun(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        boolean zigZag = false;

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

                // Add nodes to the current level list based on the zigzag flag
                if (zigZag) {
                    currentLevel.add(0, currentNode.val); // Add at the beginning
                } else {
                    currentLevel.add(currentNode.val); // Add at the end
                }

                // Add children to the queue in the normal order
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            zigZag = !zigZag;

            result.add(currentLevel);
        }


        return result;
    }

    public static void main(String[] args) {

    }
}
