package DSA.Tree.Binary_search_Tree;

import java.util.*;

public class _2_Max_Min_BST {

    public int minValue(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(0);
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
