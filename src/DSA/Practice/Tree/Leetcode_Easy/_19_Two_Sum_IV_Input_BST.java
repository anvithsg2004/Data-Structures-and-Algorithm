package DSA.Practice.Tree.Leetcode_Easy;

import java.util.ArrayList;

public class _19_Two_Sum_IV_Input_BST {

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        ArrayList<Integer> allElement = new ArrayList<>();
        inorder(root, allElement);
        return find(allElement, k);
    }

    public boolean find(ArrayList<Integer> allElement, int k) {
        int low = 0;
        int high = allElement.size() - 1;

        while (low < high) {
            if ( k == (allElement.get(low) + allElement.get(high))) {
                return true;
            } else if (k < (allElement.get(low) + allElement.get(high))) {
                high--;
            } else if (k > (allElement.get(low) + allElement.get(high))) {
                low++;
            }
        }

        return false;
    }

    public void inorder(TreeNode root, ArrayList<Integer> allElement) {
        if (root == null) {
            return;
        }

        inorder(root.left, allElement);
        allElement.add(root.val);
        inorder(root.right, allElement);
    }

    public static void main(String[] args) {

    }
}
