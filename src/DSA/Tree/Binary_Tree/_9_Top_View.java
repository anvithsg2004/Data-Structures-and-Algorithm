package DSA.Tree.Binary_Tree;

import java.util.*;

public class _9_Top_View {

    public class Pair {

        TreeNode node;

        int line;

        public Pair(TreeNode node, int line) {
            this.node = node;
            this.line = line;
        }
    }

    public ArrayList<Integer> topView(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        help(root, res);

        return res;

    }

    public void help(TreeNode root, ArrayList<Integer> res) {

        Map<Integer, TreeNode> mpp = new HashMap<>();

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {

            Pair pair = queue.poll();

            TreeNode node = pair.node;

            int line = pair.line;

            if (!mpp.containsKey(line)) {
                mpp.put(line, node);
            }

            if (root.left != null) {
                queue.add(new Pair(node.left, line - 1));
            }

            if (root.right != null) {
                queue.add(new Pair(node.right, line + 1));
            }

        }

        //Collect top view nodes in sorted order of lines
        for (TreeNode node : mpp.values()) {
            res.add(node.val);
        }

    }
}
