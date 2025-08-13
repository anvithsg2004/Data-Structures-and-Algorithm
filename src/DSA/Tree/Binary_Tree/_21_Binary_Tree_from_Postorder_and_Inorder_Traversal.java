package DSA.Tree.Binary_Tree;

import java.util.*;

//inorder =   [9, 3, 15, 20, 7]
//postorder = [9, 15, 7, 20, 3]
//       3
//      / \
//     9   20
//        /  \
//       15   7

public class _21_Binary_Tree_from_Postorder_and_Inorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inMap);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd,
                              int[] postorder, int postStart, int postEnd,
                              Map<Integer, Integer> inMap) {

        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = inMap.get(postorder[postEnd]);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(inorder, inStart, inRoot - 1,
                postorder, postStart, postStart + numsLeft - 1, inMap);

        root.right = buildTree(inorder, inRoot + 1, inEnd,
                postorder, postStart + numsLeft, postEnd - 1, inMap);

        return root;

    }
}
