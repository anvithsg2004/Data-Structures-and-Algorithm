import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder result = new StringBuilder();

        if (root == null) {
            return result.toString();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        result.append(root.val).append(",");

        while (!queue.isEmpty()) {

            TreeNode node = queue.peek();
            queue.remove();

            if (node.left != null) {
                queue.add(node.left);
                result.append(node.left.val).append(",");
            } else {
                result.append("null,");
            }

            if (node.right != null) {
                queue.add(node.right);
                result.append(node.right.val).append(",");
            } else {
                result.append("null,");
            }
        }

        int indexTill = result.length() - 1;

        while (indexTill >= 4 && result.substring(indexTill - 4, indexTill).equals("null")) {
            indexTill -= 5; // Move back 5 positions: "null,"
        }

        return result.substring(0, indexTill + 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String dataGiven) {

        StringBuilder data = new StringBuilder(dataGiven);

        int commaIndex = data.indexOf(",");
        String value = data.substring(0, commaIndex);
        data.delete(0, commaIndex + 1);

        TreeNode root = new TreeNode(Integer.parseInt(value));

        Queue<TreeNode> queue = new

    }
}
