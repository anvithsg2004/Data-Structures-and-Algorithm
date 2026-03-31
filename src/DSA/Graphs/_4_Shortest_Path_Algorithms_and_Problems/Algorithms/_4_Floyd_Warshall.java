package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems.Algorithms;

public class _4_Floyd_Warshall {
    public void floydWarshall(int[][] dist) {

        int n = dist.length;

        // Step 1: Replace -1 with INF (1e8)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (dist[i][j] == -1) {
                    dist[i][j] = (int) 1e8;
                }

                if (i == j) {
                    dist[i][j] = 0;
                }
            }
        }

        // Step 2: Main Algorithm
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (dist[i][via] != (int) 1e8 && dist[via][j] != (int) 1e8) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                    }

                }
            }
        }

        // Step 3: Convert INF back to -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (dist[i][j] == (int) 1e8) {
                    dist[i][j] = -1;
                }

            }
        }

    }
}
