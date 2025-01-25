package DSA.Practice.Tree.Leetcode_Easy;

public class _15_Count_Complete_Tree_Nodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] array = new int[1];

        sum(root, array);

        return array[0];

    }

    public void sum(TreeNode root, int[] sum) {
        if (root == null) {
            return;
        }

        sum[0] += 1;

        sum(root.left, sum);
        sum(root.right, sum);
    }

    public static void main(String[] args) {

    }
}
