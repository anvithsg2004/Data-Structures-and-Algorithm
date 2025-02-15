package DSA.Practice.Tree.GFG_Easy;

public class _1_Lowest_Common_Ancestor_in_a_BST {

    public Node LCA(Node root, Node n1, Node n2) {
        return helper(root, n1, n2);
    }

    public Node helper(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        Node left = helper(root.left, p, q);
        Node right = helper(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else if (left == right) {
            return left;
        }

        return null;
    }
}
