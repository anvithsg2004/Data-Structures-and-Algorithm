package DSA.Practice.Tree.Leetcode_Easy;

public class _6_Merge_Two_Binary_Trees {

    //Pre_Order Traversal

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //Root
        if (root1 == null && root2 == null) {
            return null;
        }

        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        TreeNode sumRoot = new TreeNode(root1.val + root2.val);

        //Left Node
        sumRoot.left = mergeTrees(root1.left, root2.left);

        //Right Node
        sumRoot.right = mergeTrees(root1.right, root2.right);

        return sumRoot;
    }

    public static void main(String[] args) {

    }
}
