package DSA.Practice.Tree.Leetcode_Easy;

import java.util.ArrayList;

public class _14_Leaf_Similar_Trees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        add(root1, first);
        add(root2, second);

//        HashSet<Integer> hashSet = new HashSet<>(first);
//        HashSet<Integer> hashSet1 = new HashSet<>(second);

//        if (hashSet.equals(hashSet1)) {
//            return true;
//        }


        //Compare the ArrayList and return the boolean value.
        if (first.equals(second)) {
            return true;
        }
        return false;
    }

    //Do Pre Order Traversal and get the leaf nodes and store it in an Arraylist

    public void add(TreeNode root, ArrayList<Integer> arrayList) {
        if (root == null) {
            return;
        }

        //If the node has both the left and right is null.
        //Store it in the ArrayList
        if (root.left == null && root.right == null) {
            arrayList.add(root.val);
        }

        //Left
        add(root.left, arrayList);
        //Right
        add(root.right, arrayList);
    }

    public static void main(String[] args) {

    }
}
