package DSA.Practice.Tree.Leetcode_Medium;

import java.util.ArrayList;

public class _16_Kth_Smallest_Element_in_a_BST {

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        inorder(root, arrayList);

        int find = arrayList.get(k - 1);

        return find;
    }

    public void inorder(TreeNode root, ArrayList<Integer> arrayList) {
        if (root == null) {
            return;
        }

        inorder(root.left, arrayList);
        arrayList.add(root.val);
        inorder(root.right, arrayList);
    }

    public static void main(String[] args) {

    }
}
