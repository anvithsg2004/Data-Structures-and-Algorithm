package DSA.Practice.Tree.Leetcode_Easy;

import java.util.ArrayList;
import java.util.List;

public class _9_Binary_Tree_Inorder_Traversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> allElements = new ArrayList<>();
        indorder(root, allElements);
        return allElements;
    }

    public void indorder(TreeNode root, List<Integer> allElements) {
        if (root == null) {
            return;
        }

        indorder(root.left, allElements);
        allElements.add(root.val);
        indorder(root.right, allElements);
    }

    public static void main(String[] args) {

    }
}
