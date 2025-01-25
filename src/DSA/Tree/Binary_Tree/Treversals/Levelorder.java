package DSA.Tree.Binary_Tree.Treversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Levelorder {

    public static List<List<Integer>> levelOrder(node root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                node nod = q.poll();
                level.add(nod.data);

                if (nod.left != null) {
                    q.add(nod.left);
                }

                if (nod.right != null) {
                    q.add(nod.right);
                }
            }

            ans.add(level);
        }

        return ans;
    }

    public List<List<Integer>> level(node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                node n = q.poll();
                level.add(n.data);
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
