package DSA.Tree.Binary_Tree.Treversals;

import java.util.ArrayList;

public class Preorder {

    public static ArrayList<Integer> preorder(node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        preOreder(root, ans);
        return ans;
    }

    public static void preOreder(node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }

        ans.add(root.data);
        preOreder(root.left, ans);
        preOreder(root.right, ans);
    }

    public static void main(String[] args) {

    }
}
