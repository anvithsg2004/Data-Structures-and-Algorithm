package DSA.Practice.Tree.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class serialize_deserialize {

    public static List<String> serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public static void helper(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("null");
            return;
        }

        list.add(String.valueOf(root.val));

        helper(root.left, list);
        helper(root.right, list);
    }

    public static TreeNode deserialize(List<String> list) {
        Collections.reverse(list);
        TreeNode node = helper2(list);
        return node;
    }

    public static TreeNode helper2(List<String> list) {
        String val = list.remove(list.size() - 1);

        if (val.charAt(0) == 'n') {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.left = helper2(list);
        node.right = helper2(list);

        return node;
    }

    public static void main(String[] args) {

    }
}
