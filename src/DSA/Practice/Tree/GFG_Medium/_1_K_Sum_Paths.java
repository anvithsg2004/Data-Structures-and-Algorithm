package DSA.Practice.Tree.GFG_Medium;

import java.util.ArrayList;
import java.util.HashMap;

public class _1_K_Sum_Paths {

    //Best Solution
    public int pathSum2(Node root, int k) {
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        //Sum Count
        //sum 0 appears once
        prefixSum.put(0, 1);

        return countPath2(root, 0, k, prefixSum);
    }

    public int countPath2(Node root, int sum, int k, HashMap<Integer, Integer> prefixSum) {
        if (root == null) {
            return 0;
        }

        sum = sum + root.data;

        int count = prefixSum.getOrDefault(sum - k, 0);

        prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);

        count = count + countPath2(root.left, sum, k, prefixSum);
        count = count + countPath2(root.right, sum, k, prefixSum);

        prefixSum.put(sum, prefixSum.get(sum) - 1);

        return count;
    }

    //My Solution
    public int sumK(Node root, int k) {
        if (root == null) return 0;
        int count = 0;

        // Store all nodes using inorder traversal
        ArrayList<Node> nodes = new ArrayList<>();
        inorder(root, nodes);

        // Find paths starting from each node
        for (Node node : nodes) {
            count += sum(node, k, 0);
        }

        return count;
    }

    // Store all nodes in an inorder traversal
    public void inorder(Node root, ArrayList<Node> nodes) {
        if (root == null) return;

        inorder(root.left, nodes);
        nodes.add(root);
        inorder(root.right, nodes);
    }

    // Recursively check all paths from the given node
    public int sum(Node root, int k, int sum) {
        if (root == null) return 0;

        sum += root.data;

        int count = (sum == k) ? 1 : 0; // Count a valid path

        // Continue checking left and right subtrees
        count += sum(root.left, k, sum);
        count += sum(root.right, k, sum);

        return count;
    }

    //My Solution but simplified.
    int count = 0;

    public int pathSum(Node root, int k) {

        if (root == null) {
            return 0;
        }

        countSum(root, 0, k);

        pathSum(root.left, k);
        pathSum(root.right, k);

        return count;
    }

    public void countSum(Node root, int sum, int k) {
        if (root == null) {
            return;
        }

        sum = sum + root.data;

        if (sum == k) {
            count++;
        }

        countSum(root.left, sum, k);
        countSum(root.right, sum, k);

    }
}
