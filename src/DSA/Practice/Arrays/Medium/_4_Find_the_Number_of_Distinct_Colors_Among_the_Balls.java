package DSA.Practice.Arrays.Medium;

import java.util.Arrays;
import java.util.HashSet;

public class _4_Find_the_Number_of_Distinct_Colors_Among_the_Balls {

    //Correct code but the memory limit exceeded.
    public static int[] queryResults(int limit, int[][] queries) {

        int n = queries.length;

        int[] result = new int[n];

        int[] balls = new int[limit + 1];

        for (int i = 0; i < n; i++) {

            int index = queries[i][0];
            int color = queries[i][1];

            balls[index] = color;

            HashSet<Integer> distinctColors = new HashSet<>();

            for (int j = 0; j < balls.length; j++) {
                if (balls[j] != 0) {
                    distinctColors.add(balls[j]);
                }
            }

            result[i] = distinctColors.size();

        }

        return result;

    }

    public static void main(String[] args) {
        int[][] queries = {{1, 4}, {2, 5}, {1, 3}, {3, 4}};
        int limit = 4;
        System.out.println(Arrays.toString(queryResults(limit, queries)));
    }

}
