package DSA.Tree.Binary_Tree;

import java.util.ArrayList;
import java.util.List;

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
}
