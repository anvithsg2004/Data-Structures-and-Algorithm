package DSA.Tree.Binary_Tree;

import java.util.*;

public class _10_Bottom_View {

    public class Pair {

        TreeNode node;

        int line;

        public Pair(TreeNode node, int line) {
            this.node = node;
            this.line = line;
        }
    }

    public ArrayList<Integer> botView(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return null;
        }

        hep(root, result);

        return result;

    }

    public void hep(TreeNode root, ArrayList<Integer> result) {

        Map<Integer, TreeNode> map = new HashMap<>();

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {

            Pair pair = queue.poll();

            TreeNode node = pair.node;

            int line = pair.line;

            map.put(line, node);

            if (root.left != null) {
                queue.add(new Pair(node, line - 1));
            }

            if (root.right != null) {
                queue.add(new Pair(node, line + 1));
            }

        }

        for (TreeNode node : map.values()) {
            result.add(node.val);
        }

    }
}
