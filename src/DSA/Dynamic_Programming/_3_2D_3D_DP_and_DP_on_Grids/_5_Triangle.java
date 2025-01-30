package DSA.Dynamic_Programming._3_2D_3D_DP_and_DP_on_Grids;

import java.util.ArrayList;
import java.util.List;

public class _5_Triangle {

    //Recursion
    public int minimumTotal(List<List<Integer>> triangle) {
        return helper(0, 0, triangle);
    }

    public int helper(int i, int j, List<List<Integer>> triangle) {

        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        int down = triangle.get(i).get(j) + helper(i + 1, j, triangle);
        int diagonal = triangle.get(i).get(j) + helper(i + 1, j + 1, triangle);

        return Math.min(down, diagonal);
    }

    //Memoization
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();

        // Initialize dp with -1
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                row.add(-1);
            }
            dp.add(row);
        }

        return helper2(0, 0, triangle, dp);
    }

    public int helper2(int i, int j, List<List<Integer>> triangle, List<List<Integer>> dp) {

        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        if (dp.get(i).get(j) != -1) {
            return dp.get(i).get(j);
        }

        int down = triangle.get(i).get(j) + helper2(i + 1, j, triangle, dp);
        int diagonal = triangle.get(i).get(j) + helper2(i + 1, j + 1, triangle, dp);

        dp.get(i).set(j, Math.min(down, diagonal)); // Correct usage of set
        return dp.get(i).get(j);
    }

}
