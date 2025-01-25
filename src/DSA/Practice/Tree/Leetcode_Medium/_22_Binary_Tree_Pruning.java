package DSA.Practice.Tree.Leetcode_Medium;

public class _22_Binary_Tree_Pruning {

    //Proper Approach
    //Post Order Traversal
    public TreeNode prune(TreeNode root) {
        //Root
        //Base Case
        if (root == null) {
            return null;
        }

        //Left
        root.left = prune(root.left);
        //Right
        root.right = prune(root.right);

        //Operation on the Root Value
        //It also acts like an if-else statement
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }

        //Root
        return root;
    }


    //My Approach
    public TreeNode pruneTree(TreeNode root) {
        helper(root);
        return root;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            if (root.left.val == 0) {
                if (checkZero(root.left)) {
                    root.left = null;
                }
            }
        }

        if (root.right != null) {
            if (root.right.val == 0) {
                if (checkZero(root.right)) {
                    root.right = null;
                }
            }
        }

        helper(root.left);
        helper(root.right);
    }

    public boolean checkZero(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = checkZero(root.left);
        boolean right = checkZero(root.right);

        return root.val == 0 && left && right;
    }
}
