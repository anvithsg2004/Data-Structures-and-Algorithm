package DSA.Practice.Tree.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Level_Order_Successor {

    public static TreeNode fun(TreeNode root, int k) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
            if (currentNode.val == k) {
                break;
            }
        }

        return queue.peek();
    }

    public static void main(String[] args) {

    }
}
