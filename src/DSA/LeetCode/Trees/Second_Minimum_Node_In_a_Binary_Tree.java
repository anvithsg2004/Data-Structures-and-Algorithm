package DSA.LeetCode.Trees;

public class Second_Minimum_Node_In_a_Binary_Tree {

    int min = Integer.MAX_VALUE;
    int secMin = Integer.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {

        if (root == null) {
            return Integer.MAX_VALUE;
        }

        min = Math.min(root.val, min);

        if (root.val < min) {
            secMin = root.val;
        }

        findSecondMinimumValue(root.left);
        findSecondMinimumValue(root.right);

        return secMin;
    }

    public static void main(String[] args) {

    }
}
