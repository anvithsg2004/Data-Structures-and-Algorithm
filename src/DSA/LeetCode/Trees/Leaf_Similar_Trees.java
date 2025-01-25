package DSA.LeetCode.Trees;

import java.util.ArrayList;
import java.util.List;

public class Leaf_Similar_Trees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        dfs(root1, l1);
        dfs(root2, l2);

        return l2.equals(l1);
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        dfs(root.left, list);
        dfs(root.right, list);
    }

    public static void main(String[] args) {

    }
}
