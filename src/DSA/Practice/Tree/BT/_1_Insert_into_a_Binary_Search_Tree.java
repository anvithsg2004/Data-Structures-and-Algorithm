package DSA.Practice.Tree.BT;

public class _1_Insert_into_a_Binary_Search_Tree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode cur = root;

        while (true) {
            if (cur.val <= val) {
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur.right = new TreeNode(val);
                    break;
                }
            } else {
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur.left = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {

    }
}
