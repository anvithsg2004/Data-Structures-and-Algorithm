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

        // Step 1: Compute sum of left and right child
        int child = 0;
        if (root.left != null) {
            child += root.left.val;
        }
        if (root.right != null) {
            child += root.right.val;
        }

        // Step 2: If child < root, update child values to maintain the property
        if (child >= root.val) {
            root.val = child;
        } else {
            if (root.left != null) {
                root.left.val = root.val;
            }
            if (root.right != null) {
                root.right.val = root.val;
            }
        }

        // Step 3: Recursive calls
        changeTree(root.left);
        changeTree(root.right);

        // Step 4: Update root value to be sum of its children
        int total = 0;
        if (root.left != null) {
            total += root.left.val;
        }
        if (root.right != null) {
            total += root.right.val;
        }

        // Only update if the node has children
        if (root.left != null || root.right != null) {
            root.val = total;
        }
    }
}
