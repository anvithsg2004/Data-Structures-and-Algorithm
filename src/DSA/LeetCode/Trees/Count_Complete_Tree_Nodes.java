package DSA.LeetCode.Trees;

public class Count_Complete_Tree_Nodes {

    int count = 0;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        count++;

        countNodes(root.left);
        countNodes(root.right);

        return count;
    }

    public static void main(String[] args) {

    }
}
