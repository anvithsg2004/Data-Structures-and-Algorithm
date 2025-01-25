package DSA.Practice.Tree.Leetcode_Medium;

import java.util.ArrayList;
import java.util.HashMap;

public class _25_Pseudo_Palindromic_Paths_in_a_Binary_Tree {

    public int pseudoPalindromicPaths(TreeNode root) {
        int count = 0;

        if (root == null) {
            return count;
        }

        ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();
        help(root, new ArrayList<>(), allPaths);

        // Check all root-to-leaf paths
        for (int i = 0; i < allPaths.size(); i++) {
            HashMap<Integer, Integer> frequencyMap = new HashMap<>();

            // Populate the frequency map
            for (int j = 0; j < allPaths.get(i).size(); j++) {
                int num = allPaths.get(i).get(j);
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }

            int oddCount = 0;

            // Count the number of digits with odd occurrences
            for (int num : frequencyMap.keySet()) {
                if (frequencyMap.get(num) % 2 != 0) {
                    oddCount++;
                }
                if (oddCount > 1) {  // If more than one odd occurrence, break early
                    break;
                }
            }

            // A path is pseudo-palindromic if at most one digit has an odd occurrence
            if (oddCount <= 1) {
                count++;
            }
        }

        return count;
    }

    public void help(TreeNode root, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> allPaths) {
        if (root == null) {
            return;
        }

        current.add(root.val);

        if (root.left == null && root.right == null) {
            allPaths.add(new ArrayList<>(current));
        }

        help(root.left, current, allPaths);
        help(root.right, current, allPaths);

        current.remove(current.size() - 1);
    }
}
