package DSA.Practice.Tree.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Average_Of_Level {

    public static List<Double> fun(TreeNode root) {
        List<Double> average = new ArrayList<>();

        if (root == null) {
            return average;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            double averageLevel = 0;


            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

                averageLevel = averageLevel +  currentNode.val;
            }

            average.add(averageLevel / levelSize);
        }

        return average;
    }

    public static void main(String[] args) {

    }
}
