package DSA.Practice.Tree.Leetcode_Medium;

import java.util.ArrayList;

public class _35_Sum_Root_to_Leaf_Numbers {

    public int sumNumbers(TreeNode root) {

        if (root == null) {
            return 0;
        }

        ArrayList<Integer> currPath = new ArrayList<>();

        String path = "";

        help(root, currPath, path);

        int sum = 0;

        for (int i = 0; i < currPath.size(); i++) {

            sum = sum + currPath.get(i);

        }

        return sum;

    }

    public void help(TreeNode root, ArrayList<Integer> currPath, String path) {

        if (root == null) {
            return;
        }

        path = path + root.val;

        if (root.left == null && root.right == null) {
            currPath.add(Integer.parseInt(path));
        } else {
            help(root.left, currPath, path);
            help(root.right, currPath, path);
        }

    }

    public static void main(String[] args) {

    }
}
