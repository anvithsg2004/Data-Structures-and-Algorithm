package DSA.Practice.Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _12_Maximum_Sum_With_at_Most_K_Elements {
    public static long maxSum(int[][] grid, int[] limits, int k) {

        for (int[] mat : grid) {
            Arrays.sort(mat);
        }

        ArrayList<Integer> numbersAfterLimit = new ArrayList<>();

        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {

            int limit = limits[i];

            for (int j = m - 1; j >= 0; j--) {
                if (limit == 0) {
                    break;
                }
                limit = limit - 1;
                numbersAfterLimit.add(grid[i][j]);
            }
        }

        Collections.sort(numbersAfterLimit);

        int listSize = numbersAfterLimit.size();

        long sum = 0;

        for (int i = listSize - 1; i >= 0; i--) {
            if (k == 0) {
                break;
            }
            sum = sum + numbersAfterLimit.get(i);
            k = k - 1;
        }

        return sum;

    }

    public static void main(String[] args) {
        int[][] grid = {{5, 3, 7}, {8, 2, 6}};
        int[] limit = {2, 2};
        int k = 3;
        maxSum(grid, limit, k);
    }

}
