package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems;

import java.util.*;

class Edge {
    int node, cost;

    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

class FlightInfo {
    int stopsSoFar, node, costSoFar;

    public FlightInfo(int stops, int node, int cost) {
        this.stopsSoFar = stops;
        this.node = node;
        this.costSoFar = cost;
    }
}

class _7_Cheapest_flights_within_k_stops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];

            adj.get(from).add(new Edge(to, cost));
        }

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        Queue<FlightInfo> queue = new LinkedList<>();
        queue.offer(new FlightInfo(0, src, 0));

        while (!queue.isEmpty()) {
            FlightInfo current = queue.poll();
            int stopsSoFar = current.stopsSoFar;
            int currentNode = current.node;
            int costSoFar = current.costSoFar;

            if (stopsSoFar > k) continue;

            for (Edge edge : adj.get(currentNode)) {
                int nextNode = edge.node;
                int flightCost = edge.cost;

                if (minCost[nextNode] > costSoFar + flightCost) {
                    minCost[nextNode] = costSoFar + flightCost;
                    queue.offer(new FlightInfo(stopsSoFar + 1, nextNode, minCost[nextNode]));
                }
            }
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}
