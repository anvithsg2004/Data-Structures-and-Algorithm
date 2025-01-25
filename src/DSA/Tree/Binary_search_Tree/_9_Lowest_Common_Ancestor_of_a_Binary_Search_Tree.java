package DSA.Tree.Binary_search_Tree;

public class _9_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {


    //Use this is for all.
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        return right;
    }


    //Do not use this.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        int curr = root.val;

        if (curr < p.val && curr < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (curr > p.val && curr > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
    }

    public static void main(String[] args) {

    }
}
