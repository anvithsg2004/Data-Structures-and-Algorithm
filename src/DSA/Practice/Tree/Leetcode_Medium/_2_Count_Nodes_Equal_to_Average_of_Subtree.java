package DSA.Practice.Tree.Leetcode_Medium;

public class _2_Count_Nodes_Equal_to_Average_of_Subtree {

    //Post-order traversal

    public int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] count = new int[1];

        help(root, count);

        return count[0];
    }

    public int[] help(TreeNode root, int[] count) {

        //Root
        if (root == null) {
            return new int[]{0, 0};
        }

        //Left
        int[] left = help(root.left, count);
        //Right
        int[] right = help(root.right, count);


        //Operation done on the values returned by root
        int subTreeSum = left[0] + right[0] + root.val;
        int noOfSubTreeNodes = left[1] + right[1] + 1;

        int average = subTreeSum / noOfSubTreeNodes;

        if (root.val == average) {
            count[0] = count[0] + 1;
        }

        //Root
        return new int[]{subTreeSum, noOfSubTreeNodes};
    }
}
