package DSA.Practice.Graphs.Easy;

public class _2_Find_Center_of_Star_Graph {

    public static int findCenter(int[][] edges) {

        int n = Integer.MIN_VALUE;

        for (int[] edge : edges) {
            n = Math.max(n, Math.max(edge[0], edge[1]));
        }

        int[] inDegree = new int[n + 1];

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            inDegree[u]++;
            inDegree[v]++;

        }

        int result = -1;

        for (int i = 0; i <= n; i++) {
            if (inDegree[i] == n - 1) {
                result = i;
            }
        }

        return result;


    }

    public static void main(String[] args) {

        int[][] edges = {
                {1, 18}, {18, 2}, {3, 18}, {18, 4}, {18, 5}, {6, 18}, {18, 7},
                {18, 8}, {18, 9}, {18, 10}, {18, 11}, {12, 18}, {18, 13},
                {18, 14}, {15, 18}, {16, 18}, {17, 18}
        };

        System.out.println(findCenter(edges));

    }
}
