package DSA.Tree.Binary_search_Tree;

public class _3_Floor {

    public int floor(TreeNode root, int x) {
        int floor = -1;

        while (root != null) {
            if (root.val == x) {
                return root.val; // Return the value if found
            } else if (root.val < x) {
                floor = root.val; // Update floor
                root = root.right; // Move right
            } else {
                root = root.left; // Move left
            }
        }

        return floor; // Return the floor value or -1 if not found
    }

    public static void main(String[] args) {
        // You can add test cases here
    }
}
