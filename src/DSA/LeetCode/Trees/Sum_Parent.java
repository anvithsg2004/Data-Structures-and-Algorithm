package DSA.LeetCode.Trees;

public class Sum_Parent {

    public boolean checkTree(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        int sum = 0;
        if (root.left != null) {
            sum = sum + root.left.val;
        }
        if (root.right != null) {
            sum = sum + root.right.val;
        }

        if (sum != root.val) {
            return false;
        }

        return checkTree(root.left) && checkTree(root.right);
    }

    public static void main(String[] args) {

    }
}
