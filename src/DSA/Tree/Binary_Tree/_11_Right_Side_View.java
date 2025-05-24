package DSA.Tree.Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _11_Right_Side_View {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursionRight(root, 0, res);
        return res;
    }

    public void recursionRight(TreeNode root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(root.val);
        }

        recursionRight(root.right, level + 1, res);
        recursionRight(root.left, level + 1, res);
    }

    public List<Integer> rightSideView2(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                int val = node.val;

                if (i == size - 1) {
                    result.add(val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

            }

        }

        return result;

    }
}
