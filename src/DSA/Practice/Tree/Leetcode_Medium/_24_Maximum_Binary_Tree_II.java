package DSA.Practice.Tree.Leetcode_Medium;

import java.util.ArrayList;
import java.util.Collections;

public class _24_Maximum_Binary_Tree_II {

    //Error is there.
    //Not passing all the test cases.
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        ArrayList<Integer> result = new ArrayList<>();
        inorder(root, result);
        result.add(val);
        Collections.sort(result);
        Collections.reverse(result);
        return helper(result, 0, result.size() - 1);
    }

    public TreeNode helper(ArrayList<Integer> nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int indMax = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums.get(i) > nums.get(indMax)) {
                indMax = i;
            }
        }

        TreeNode root = new TreeNode(nums.get(indMax));

        root.left = helper(nums, start, indMax - 1);
        root.right = helper(nums, indMax + 1, end);

        return root;
    }

    public void inorder(TreeNode root, ArrayList<Integer> arrayList) {
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
