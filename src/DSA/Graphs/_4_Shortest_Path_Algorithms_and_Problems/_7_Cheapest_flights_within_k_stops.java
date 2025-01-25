package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//Some error is there.
//Check it.

class Pair5 {
    int node;
    int weight;

    public Pair5(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Tuple5 {
    int stops;
    int node;
    int distance;

    public Tuple5(int stops, int node, int distance) {
        this.stops = stops;
        this.node = node;
        this.distance = distance;
    }
}

public class _7_Cheapest_flights_within_k_stops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<Pair5>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int to = flight[0];
            int from = flight[1];
            int price = flight[2];

            adj.get(to).add(new Pair5(from, price));
        }

        PriorityQueue<Tuple5> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        pq.add(new Tuple5(0, src, 0));

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);

        dist[src] = 0;

        while (!pq.isEmpty()) {

            Tuple5 current = pq.poll();
            int stops = current.stops;
            int node = current.node;
            int distance = current.distance;

            if (stops > k) {
                continue;
            }

            for (Pair5 itr : adj.get(node)) {
                int adjNode = itr.node;
                int edW = itr.weight;

                if (distance + edW < dist[adjNode] && stops <= k) {
                    dist[adjNode] = distance + edW;
                    pq.add(new Tuple5(stops + 1, adjNode, distance + edW));
                }
            }

        }

        if (dist[dst] == (int) 1e9) {
            return -1;
        }

        return dist[dst];

    }

    public static void main(String[] args) {

    }
}
