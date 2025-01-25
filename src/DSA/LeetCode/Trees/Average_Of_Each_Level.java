package DSA.LeetCode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Average_Of_Each_Level {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> last = new ArrayList<>();

        if (root == null) {
            return last;
        }

        double data = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode nod = q.poll();
                data = data + nod.val;

                if (nod.left != null) {
                    q.add(nod.left);
                }

                if (nod.right != null) {
                    q.add(nod.right);
                }
            }

            data = data / size;
            last.add(data);

            data = 0;
        }

        return last;
    }

    public static void main(String[] args) {

    }
}
