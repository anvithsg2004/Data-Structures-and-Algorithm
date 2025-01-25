package DSA.Practice.Tree.Leetcode_Medium;

import java.util.Stack;

class BSTIterator {

    //Remember this code.

    public Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    //Put all left nodes in the stack
    public void pushAll(TreeNode root) {
        for (; root != null; stack.push(root), root = root.left) ;
    }

    public int next() {
        TreeNode tempNode = stack.pop();
        pushAll(tempNode.right);
        return tempNode.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
