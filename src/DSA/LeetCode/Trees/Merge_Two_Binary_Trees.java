package DSA.LeetCode.Trees;

public class Merge_Two_Binary_Trees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        root1.val = root1.val + root2.val;

        if (root2.left != null) {
            root1.left = mergeTrees(root1.left, root2.left);
        }

        if (root2.right != null) {
            root1.right = mergeTrees(root1.right, root2.right);
        }

        return root1;
    }

    public static void main(String[] args) {

    }
}
