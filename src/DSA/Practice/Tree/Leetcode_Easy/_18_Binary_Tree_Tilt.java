package DSA.Practice.Tree.Leetcode_Easy;

public class _18_Binary_Tree_Tilt {

    //PostOrder Traversal

    public int findTilt(TreeNode root) {
        int[] totalTilt = new int[1];  // Store the total tilt here
        sum(root, totalTilt);  // Helper function to calculate tilt and sum of nodes
        return totalTilt[0];  // Return the total tilt
    }

    public int sum(TreeNode root, int[] totalTilt) {

        //Root
        if (root == null) {
            return 0;
        }

        //Left
        int leftSum = sum(root.left, totalTilt);

        //Right
        int rightSum = sum(root.right, totalTilt);


        //Operation is done by using the root node return at the last.
        int tilt = Math.abs(leftSum - rightSum);

        totalTilt[0] = totalTilt[0] + tilt;

        //Root
        return root.val + leftSum + rightSum;
    }

    public static void main(String[] args) {

    }
}
