package DSA.LeetCode.Trees;

public class Sum_of_Left_Leaves {

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }

//        if (root.left == null && root.right == null) {
//            return 0;
//        }

        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum = sum + root.val;
        }

        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);

        return sum;
    }

    public static void main(String[] args) {

    }
}
