package DSA.Tree.Binary_Tree;

public class _16_Child_Sum_Property {

    public void changeTree(TreeNode root) {
        if (root == null) {
            return;
        }

        int child = 0;

        if (root.left != null) {
            child = child + root.left.val;
        }

        if (root.right != null) {
            child = child + root.right.val;
        }

        if (child >= root.val) {
            root.val = child;
        } else {
            if (root.left != null) {
                root.left.val = root.val;
            } else if (root.right != null) {
                root.right.val = root.val;
            }
        }

        changeTree(root.left);
        changeTree(root.right);

        int total = 0;

        if (root.left != null) {
            total = total + root.left.val;
        }

        if (root.right != null) {
            total = total + root.right.val;
        }

        if (root.left != null || root.right != null) {
            root.val = total;
        }
    }

    public static void main(String[] args) {

    }
}
