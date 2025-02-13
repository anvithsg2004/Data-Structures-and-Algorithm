package DSA.Practice.Tree.GFG_Medium;

import java.util.ArrayList;

public class _2_Pair_Sum_in_BST {
    public boolean findTarget(Node root, int target) {

        ArrayList<Integer> arr = new ArrayList<>();
        helper(root, arr);

        int n = arr.size();

        int left = 0;
        int right = n - 1;

        while (left < right) {

            int sum = arr.get(right) + arr.get(left);

            if (sum == target) {
                return true;
            }

            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            }

        }

        return false;

    }

    public void helper(Node root, ArrayList<Integer> arr) {

        if (root == null) {
            return;
        }

        helper(root.left, arr);
        arr.add(root.data);
        helper(root.right, arr);

    }
}
