package DSA.Tree.Binary_Tree;

public class _16_Child_Sum_Property {

    //Function: changeTree(TreeNode root)
    //Step 1: Compute the sum of left and right child nodes (child).
    //Step 2: If child ≥ root.val, update root.val = child.
    //Step 3: If child < root.val, increase the child node values to maintain the property.
    //Step 4: Recursively process left and right subtrees.
    //Step 5: After recursion, update the parent node to be the sum of its children.

    public void changeTree(TreeNode root) {
        if (root == null) {
            return;
        }

        int child = 0;

        if (root.left != null) {
            child = child + root.left.val;
        }

        if (root.right != null) {
            child = child + root.right.val;
        }

        if (child >= root.val) {
            root.val = child;
        } else {
            if (root.left != null) {
                root.left.val = root.val;
            } else if (root.right != null) {
                root.right.val = root.val;
            }
        }

        changeTree(root.left);
        changeTree(root.right);

        int total = 0;

        if (root.left != null) {
            total = total + root.left.val;
        }

        if (root.right != null) {
            total = total + root.right.val;
        }

        if (root.left != null || root.right != null) {
            root.val = total;
        }
    }
}
