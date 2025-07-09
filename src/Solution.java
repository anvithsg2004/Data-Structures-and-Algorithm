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

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Map<TreeNode, TreeNode> childParent = new HashMap<>();
        trackParents(root, childParent);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);

        ArrayList<TreeNode> visited = new ArrayList<>();

        while (!queue.isEmpty()) {

            int size = queue.size();

            if (k == 0) {
                break;
            }

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.peek();
                queue.remove();
                visited.add(node);

                if (node.left != null && !visited.contains(node.left)) {
                    queue.add(node.left);
                    result.add(node.left.val);
                }

                if (node.right != null && !visited.contains(node.right)) {
                    queue.add(node.right);
                    result.add(node.right.val);
                }

                if (childParent.containsKey(node) && childParent.get(node) != null && !visited.contains(childParent.get(node))) {
                    queue.add(childParent.get(node));
                    result.add(childParent.get(node).val);
                }

            }

            k--;

        }

        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }

        return result;

    }

    public void trackParents(TreeNode root, Map<TreeNode, TreeNode> map) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        map.put(root, null);

        while (!queue.isEmpty()) {

            TreeNode node = queue.peek();
            queue.remove();

            if (node.left != null) {
                map.put(node.left, node);
                queue.add(node.left);
            }

            if (node.right != null) {
                map.put(node.right, node);
                queue.add(node.right);
            }

        }

    }

}
