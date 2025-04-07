package DSA.Tree.Binary_search_Tree;

//Input
//preorder = [8, 5, 1, 7, 10, 12]
//        8
//       / \
//      5   10
//     / \    \
//    1   7   12

public class _10_Construct_Binary_Search_Tree_from_Preorder_Traversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        // Start constructing the BST with the first element as root
        // Integer.MAX_VALUE is the initial bound since there are no constraints at the start
        int[] index = new int[]{0}; // Using an array to keep track of the current index
        return constructBST(preorder, Integer.MAX_VALUE, index);
    }

    public TreeNode constructBST(int[] preorder, int upperBound, int[] index) {
        // Base condition: If all elements have been processed or the current value exceeds the allowed bound
        if (index[0] >= preorder.length || preorder[index[0]] > upperBound) {
            return null;
        }

        // Create a new TreeNode with the current element from the preorder array
        TreeNode node = new TreeNode(preorder[index[0]]);

        // Move to the next index since we have used the current element
        index[0]++;

        // Construct the left subtree with an updated upper bound (current node's value)
        node.left = constructBST(preorder, node.val, index);

        // Construct the right subtree with the same upper bound as given
        node.right = constructBST(preorder, upperBound, index);

        // Return the constructed node
        return node;
    }
}
