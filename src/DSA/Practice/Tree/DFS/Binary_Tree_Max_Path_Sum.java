package DSA.Practice.Tree.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Binary_Tree_Max_Path_Sum {

    public int maxPathSum(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum = help(root, 0, arrayList);
        return Collections.max(arrayList);
    }

    public int help(TreeNode root, int sum, ArrayList<Integer> arrayList) {
        if (root == null) {
            return 0;
        }

        sum = sum  + root.val;

        if (root.left == null && root.right == null) {
            arrayList.add(sum);
            return sum;
        }

        return help(root.left, sum, arrayList) + help(root.right, sum, arrayList);
    }

    public static void main(String[] args) {

    }
}
