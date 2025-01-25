package DSA.Practice.Tree.Leetcode_Easy;

public class _2_Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree {

    //Remember the code
    //it is search algo in for the trees

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }

        // If the original node matches the target, return the corresponding cloned node
        if (original == target) {
            return cloned;
        }

        // Recursively search in the left and right subtrees
        TreeNode leftResult = getTargetCopy(original.left, cloned.left, target);
        if (leftResult != null) {
            return leftResult;  // If found in the left subtree, return it
        }

        // Otherwise, search in the right subtree
        return getTargetCopy(original.right, cloned.right, target);
    }

    public static void main(String[] args) {

    }
}
