package DSA.Practice.Tree.Leetcode_Medium;

public class _5_Maximum_Binary_Tree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) {
            return null;
        }

        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        //Search for the Maximum Number index in the array
        int indMax = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[indMax]) {
                indMax = i;
            }
        }

        //Create a node for this Maximum number
        TreeNode root = new TreeNode(nums[indMax]);

        //Same as for a left
        root.left = helper(nums, start, indMax - 1);
        //Same as for a right
        root.right = helper(nums, indMax + 1, end);

        return root;
    }
}
