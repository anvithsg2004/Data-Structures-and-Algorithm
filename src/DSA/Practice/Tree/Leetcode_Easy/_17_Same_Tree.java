package DSA.Practice.Tree.Leetcode_Easy;

public class _17_Same_Tree {

    //Pre Order Traversal

    public boolean isSameTree(TreeNode p, TreeNode q) {

        //Root
        if (p == null && q == null) {
            return true;
        }

        //If anyone is not there then it is false
        if (p == null || q == null) {
            return false;
        }

        //     Root              Left                          Right
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

    }
}
