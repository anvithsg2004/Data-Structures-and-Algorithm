package DSA.Practice.Tree.Leetcode_Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _37_Most_Frequent_Subtree_Sum {

    public int[] findFrequentTreeSum(TreeNode root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        helper(root, new ArrayList<>(), result);

        Map<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < result.size(); i++) {

            int sum = 0;

            for (int j = 0; j < result.get(i).size(); j++) {

                sum = sum + result.get(i).get(j);

            }

            frequency.put(sum, frequency.getOrDefault(sum, 0) + 1);

        }

        // Find the maximum frequency among the sums
        int maxFreq = 0;
        for (int freq : frequency.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        // Collect all sums with the maximum frequency
        List<Integer> mostFrequentSums = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == maxFreq) {
                mostFrequentSums.add(entry.getKey());
            }
        }

        // Convert the list of most frequent sums to an array
        int[] resultArray = new int[mostFrequentSums.size()];
        for (int i = 0; i < mostFrequentSums.size(); i++) {
            resultArray[i] = mostFrequentSums.get(i);
        }

        return resultArray;

    }

    public void helper(TreeNode root, ArrayList<Integer> currPath, ArrayList<ArrayList<Integer>> allPath) {

        if (root == null) {
            return;
        }

        currPath.add(root.val);

        if (root.left == null && root.right == null) {
            allPath.add(new ArrayList<>(currPath));
        }

        helper(root.left, currPath, allPath);
        helper(root.right, currPath, allPath);

        currPath.remove(currPath.size() - 1);

    }

    public static void main(String[] args) {

    }
}
