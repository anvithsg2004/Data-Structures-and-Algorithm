package DSA.LeetCode.Trees;

public class Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree {

    TreeNode ans;

    public TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null) {
            return cloned;
        }

        if (cloned.val == target.val) {
            ans = cloned;
        }

        getTargetCopy(original, cloned.left, target);
        getTargetCopy(original, cloned.right, target);

        return ans;
    }

    public static void main(String[] args) {

    }
}
