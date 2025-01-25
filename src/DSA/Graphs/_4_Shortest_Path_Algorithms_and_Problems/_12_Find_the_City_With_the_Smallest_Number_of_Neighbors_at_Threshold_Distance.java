package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems;

public class _12_Find_the_City_With_the_Smallest_Number_of_Neighbors_at_Threshold_Distance {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            dist[u][v] = w;
            dist[v][u] = w;
        }

        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int countCity = n;
        int cityNo = -1;

        for (int city = 0; city < n; city++) {
            int count = 0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (dist[city][adjCity] <= distanceThreshold) {
                    count++;
                }
            }

            if (count <= countCity) {
                countCity = count;
                cityNo = city;
            }
        }

        return cityNo;

    }

    public static void main(String[] args) {

    }
}
