package DSA.Recursion.Kunal_Kushwaha.Permutations;

import java.util.ArrayList;
import java.util.List;

public class _4_Permutations {
    public List<List<Integer>> fun(int[] arr) {

        int n = arr.length;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        boolean[] used = new boolean[n];

        backtrack(arr, used, result, current);

        return result;

    }

    public void backtrack(int[] arr, boolean[] used, List<List<Integer>> result, List<Integer> current) {

        if (current.size() == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            if (used[i]) {
                continue;
            }

            used[i] = true;
            current.add(arr[i]);

            backtrack(arr, used, result, current);

            current.remove(current.size() - 1);
            used[i] = false;

        }

    }
}
