package DSA.Practice.Tree.DFS;
//POST ORDER
//LEFT RIGHT ROOT

public class Diameter_Of_Tree {

    int diameter = 0;

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, dia);


        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int diameter(TreeNode root) {
        height(root);
        return diameter;
    }

    public static void main(String[] args) {

    }
}
