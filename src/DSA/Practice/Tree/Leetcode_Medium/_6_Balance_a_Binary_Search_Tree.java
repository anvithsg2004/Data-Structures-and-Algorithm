package DSA.Practice.Tree.Leetcode_Medium;

import java.util.ArrayList;
import java.util.List;

public class _6_Balance_a_Binary_Search_Tree {

    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> result = new ArrayList<>();
        inorder(root, result);

        return helper(result, 0, result.size() - 1);
    }

    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    //Same as the before question
    public TreeNode helper(List<Integer> result, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        //Create a node for the gotten node
        TreeNode node = new TreeNode(result.get(mid));

        //Left Node
        node.left = helper(result, start, mid - 1);
        //Right Node
        node.right = helper(result, mid + 1, end);

        return node;
    }

    public static void main(String[] args) {

    }
}
