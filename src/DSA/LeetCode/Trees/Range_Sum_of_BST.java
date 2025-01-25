package DSA.LeetCode.Trees;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
    }
}

public class Range_Sum_of_BST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int ans = 0;

        if (root.val >= low && root.val <= high) {
            ans = ans + root.val;
        }

        ans = ans + rangeSumBST(root.left, low, high);
        ans = ans + rangeSumBST(root.right, low, high);

        return ans;
    }

    public static void main(String[] args) {

    }
}
