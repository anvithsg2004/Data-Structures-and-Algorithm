package DSA.Recursion.Kunal_Kushwaha.AllPaths;

import java.util.ArrayList;
import java.util.List;

public class _1_All_Paths {
    public static void findPaths(int target, List<Integer> currentPath, List<List<Integer>> allPaths) {
        // Base case: If target is exactly 0, store the current path as a valid combination.
        if (target == 0) {
            allPaths.add(new ArrayList<>(currentPath));
            return;
        }

        // If the target becomes negative, this path is invalid.
        if (target < 0) {
            return;
        }

        // Option 1: Subtract 2
        currentPath.add(2);
        findPaths(target - 2, currentPath, allPaths);
        // Backtrack: Remove the last added number to try other options
        currentPath.remove(currentPath.size() - 1);

        // Option 2: Subtract 3
        currentPath.add(3);
        findPaths(target - 3, currentPath, allPaths);
        // Backtrack: Remove the last added number to try other options
        currentPath.remove(currentPath.size() - 1);
    }
}
