package DSA.Practice.Tree.Leetcode_Medium;

import java.util.ArrayList;

public class _20_Root_To_Node {
    public boolean findRootToNode(TreeNode root, int target, ArrayList<Integer> arrayList) {
        if (root == null) {
            return false;
        }

        arrayList.add(root.val);

        if (root.val == target) {
            return true;
        }

        if (findRootToNode(root.left, target, arrayList) || findRootToNode(root.right, target, arrayList)) {
            return true;
        }

        //After coming back from the node, it removes the last node.
        arrayList.remove(arrayList.size() - 1);
        return false;
    }
}
