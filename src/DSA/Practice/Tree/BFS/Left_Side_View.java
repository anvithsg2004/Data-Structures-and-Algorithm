package DSA.Practice.Tree.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Left_Side_View {

    public static List<Integer> fun(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();


            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (i == 0) {
                    result.add(currentNode.val);
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
