package DSA.Practice.Tree.BT;

public class Prefix_Sum {
    public void prefixSum(TreeNode root, int runningSum) {

        if (root == null) {
            return;
        }

        root.val = root.val + runningSum;

        prefixSum(root.left, root.val);
        prefixSum(root.right, root.val);

    }
}
