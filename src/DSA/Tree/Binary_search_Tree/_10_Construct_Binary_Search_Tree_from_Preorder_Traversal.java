package DSA.Tree.Binary_search_Tree;

public class _10_Construct_Binary_Search_Tree_from_Preorder_Traversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        return help(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    public TreeNode help(int[] a, int bound, int[] i) {
        if (i[0] == a.length || a[i[0]] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(a[i[0]++]);
        root.left = help(a, root.val, i);
        root.right = help(a, bound, i);

        return root;
    }

    public static void main(String[] args) {

    }
}
