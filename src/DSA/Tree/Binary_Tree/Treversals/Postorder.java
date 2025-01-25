package DSA.Tree.Binary_Tree.Treversals;

import java.util.ArrayList;

public class Postorder {

    public static ArrayList<Integer> postorder(node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        return ans;
    }

    public static void postOrder(node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }

        postOrder(root.left, ans);
        postOrder(root.right, ans);
        ans.add(root.data);
    }

    public static void main(String[] args) {

    }
}
