package DSA.Practice.Tree.Leetcode_Medium;

public class _14_Distribute_Coins_in_Binary_Tree {

    //See Video

    int moves = 0;

    public int distributeCoins(TreeNode root) {
        postDFS(root);
        return moves;
    }

    public int postDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMoves = postDFS(root.left);
        int rightMoves = postDFS(root.right);

        root.val = leftMoves + rightMoves + (root.val - 1);
        moves = moves + Math.abs(root.val);

        return root.val;
    }

    public static void main(String[] args) {

    }
}
