package DSA.LeetCode.Trees;

import java.util.ArrayList;
import java.util.List;

public class Binary_To_Decimal_Root_Node {

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<Integer> currentPath = new ArrayList<>();
        List<List<Integer>> allPaths = new ArrayList<>();

        findAllPaths(root, currentPath, allPaths);

        List<Integer> decimalNumbers = new ArrayList<>();
        for (List<Integer> binaryPath : allPaths) {
            int decimalNumber = convertBinaryListToDecimal(binaryPath);
            decimalNumbers.add(decimalNumber);
        }

        int sum = 0;

        // Print the resulting decimal numbers
        for (int decimal : decimalNumbers) {
            sum = sum + decimal;
        }

        return sum;
    }

    public int convertBinaryListToDecimal(List<Integer> binaryList) {
        int decimalNumber = 0;
        int power = binaryList.size() - 1; // Start with the highest power

        for (int digit : binaryList) {
            decimalNumber += digit * Math.pow(2, power);
            power--;
        }

        return decimalNumber;
    }

    public void findAllPaths(TreeNode node, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (node == null) {
            return;
        }

        // Add the current node to the path
        currentPath.add(node.val);

        // If it's a leaf node, add the path to the list of all paths
        if (node.left == null && node.right == null) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            // Continue the path with the left and right child
            findAllPaths(node.left, currentPath, allPaths);
            findAllPaths(node.right, currentPath, allPaths);
        }

        // Backtrack to explore other paths
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {

    }
}
