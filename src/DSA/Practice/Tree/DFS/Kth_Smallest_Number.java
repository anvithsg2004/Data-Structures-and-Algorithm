package DSA.Practice.Tree.DFS;

import java.util.ArrayList;

public class Kth_Smallest_Number {

    public static int fun(TreeNode root, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        inorder(root, arrayList);
        return arrayList.get(k);
    }

    public static void inorder(TreeNode root, ArrayList<Integer> arrayList) {
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
