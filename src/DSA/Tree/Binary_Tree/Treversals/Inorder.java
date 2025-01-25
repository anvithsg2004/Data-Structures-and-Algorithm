package DSA.Tree.Binary_Tree.Treversals;

import java.util.ArrayList;

class node {
    int data;
    node left;
    node right;

    public node(int data) {
        this.data = data;
    }
}

public class Inorder {

    public static ArrayList<Integer> inorder(node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        inOreder(root, ans);
        return ans;
    }

    public static void inOreder(node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }

        inOreder(root.left, ans);
        ans.add(root.data);
        inOreder(root.right, ans);
    }

    public static void main(String[] args) {

    }
}
