package DSA.Tree.Binary_search_Tree;

import java.util.Stack;

class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);    // Push current node
            node = node.left;    // Move to left child
        }
    }
}
