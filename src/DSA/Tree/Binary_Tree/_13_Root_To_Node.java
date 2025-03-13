package DSA.Tree.Binary_Tree;

import java.util.ArrayList;

public class _13_Root_To_Node {

    public static boolean getPath(TreeNode root, ArrayList<Integer> arr, int val) {
        if (root == null) {
            return false;
        }

        arr.add(root.val);

        if (root.val == val) {
            return true;
        }

        if (getPath(root.left, arr, val) || getPath(root.right, arr, val)) {
            return true;
        }

        arr.remove(arr.size() - 1);

        return false;
    }

    public static ArrayList<Integer> solve(TreeNode root, int val) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (root == null) {
            return null;
        }

        getPath(root, arr, val);

        return arr;
    }
}
