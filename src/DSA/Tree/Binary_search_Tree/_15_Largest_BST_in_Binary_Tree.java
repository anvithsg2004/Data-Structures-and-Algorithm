package DSA.Tree.Binary_search_Tree;

public class _15_Largest_BST_in_Binary_Tree {

    class NodeValue {

        public int maxNode;
        public int minNode;
        public int maxSize;

        public NodeValue(int minNode, int maxNode, int maxSize) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSize = maxSize;
        }
    }

    public NodeValue help(TreeNode root) {

        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = help(root.left);
        NodeValue right = help(root.right);

        if (left.maxNode < root.val && root.val < right.minNode) {
            //It is a BST
            return new NodeValue(Math.min(root.val, left.minNode), Math.max(root.val, right.maxNode), left.maxSize + right.maxSize + 1);
        }


        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));

    }

    public int largestBst(TreeNode root) {

        return help(root).maxSize;

    }
}
