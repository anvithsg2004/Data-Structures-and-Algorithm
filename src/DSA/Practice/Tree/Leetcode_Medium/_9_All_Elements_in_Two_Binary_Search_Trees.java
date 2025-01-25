package DSA.Practice.Tree.Leetcode_Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _9_All_Elements_in_Two_Binary_Search_Trees {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        //If the both Tree are null.
        if (root1 == null && root2 == null) {
            return null;
        }

        //If the other Tree is null.
        if (root1 == null) {
            List<Integer> res2 = new ArrayList<>();
            inorder(root2, res2);
            return res2;
        }

        //If the other Tree is null.
        if (root2 == null) {
            List<Integer> res1 = new ArrayList<>();
            inorder(root1, res1);
            return res1;
        }

        //If the both Tree are not null.
        List<Integer> result = new ArrayList<>();
        inorder(root1, result);
        inorder(root2, result);
        Collections.sort(result);

        return result;
    }

    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    public static void main(String[] args) {

    }
}
