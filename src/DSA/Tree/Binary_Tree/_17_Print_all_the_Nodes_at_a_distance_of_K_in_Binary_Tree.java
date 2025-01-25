package DSA.Tree.Binary_Tree;

import java.util.*;


public class _17_Print_all_the_Nodes_at_a_distance_of_K_in_Binary_Tree {

    public void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_track) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null) {
                parent_track.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parent_track.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_Tree = new HashMap<>();
        markParents(root, parent_Tree);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(target);
        visited.put(target, true);
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (distance == k) {
                break;
            }

            distance++;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }

                if (current.right != null && visited.get(current.right) == null) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }

                if (parent_Tree.get(current) != null && visited.get(parent_Tree.get(current)) == null) {
                    queue.offer(parent_Tree.get(current));
                    visited.put(parent_Tree.get(current), true);
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result.add(current.val);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
