package DSA.Tree.Binary_Tree;

import java.util.*;

class Tuple {

    TreeNode node;
    int line;
    int level;

    public Tuple(TreeNode node, int line, int level) {
        this.node = node;
        this.line = line;
        this.level = level;
    }

}

public class _8_Vertical_Order_Traversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {

            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int line = tuple.line;
            int level = tuple.level;

            if (!map.containsKey(line)) {
                map.put(line, new TreeMap<>());
            }

            if (!map.get(line).containsKey(level)) {
                map.get(line).put(level, new PriorityQueue<>());
            }

            map.get(line).get(level).offer(node.val);

            if (node.left != null) {
                queue.offer(new Tuple(node.left, line - 1, level + 1));
            }

            if (node.right != null) {
                queue.offer(new Tuple(node.right, line + 1, level + 1));
            }

        }

        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> levelS : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : levelS.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {

    }
}
