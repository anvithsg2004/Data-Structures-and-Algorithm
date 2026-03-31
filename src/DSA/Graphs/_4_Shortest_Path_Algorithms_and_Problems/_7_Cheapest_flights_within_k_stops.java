package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems;

import java.util.*;

class _7_Cheapest_flights_within_k_stops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] i : flights) {
            int row = i[0];
            int col = i[1];
            int price = i[2];

            adj.get(row).add(new int[]{col, price});
        }

        int[][] dist = new int[n][k + 2];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        pq.add(new int[]{src, 0, 0});
        dist[0][0] = 0;

        while (!pq.isEmpty()) {

            int[] current = pq.poll();
            int node = current[0];
            int stops = current[1];
            int cost = current[2];

            if (node == dst) {
                return cost;
            }

            if (stops > k) {
                continue;
            }

            for (int[] neighbour : adj.get(node)) {

                int next = neighbour[0];
                int weight = neighbour[1];

                int newWeight = cost + weight;

                if (newWeight < dist[next][stops + 1]) {
                    dist[next][stops + 1] = newWeight;
                    pq.add(new int[]{next, stops + 1, newWeight});
                }

            }

        }

        return -1;

    }
}
