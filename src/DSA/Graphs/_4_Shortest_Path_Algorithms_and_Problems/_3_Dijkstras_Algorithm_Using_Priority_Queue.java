package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems;

//Important Points
//Dijkstra's Algorithm :-
//1) It does not work for either negative values or negative cycles.
//2) For Negative Weights it will go for Infinite Loop.

// Why Priority Queue and not Queue?
// Because you do not have to encounter too many paths.
// We can finish the task in the fastest way possible.

//Time Complexity :- E log V
//E :- No of Edges
//V :- No of Vertices

import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair2 {
    int node;
    int distance;

    public Pair2(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class _3_Dijkstras_Algorithm_Using_Priority_Queue {

    public ArrayList<Integer> dijkstra(ArrayList<ArrayList<Pair2>> adj, int src) {

        //Min Heap
        PriorityQueue<Pair2> priorityQueue = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        priorityQueue.add(new Pair2(src, 0));

        int v = adj.size();

        ArrayList<Integer> dist = new ArrayList<>(v);

        for (int i = 0; i < v; i++) {
            dist.add((int) 1e9);
        }

        dist.add(src, 0);

        while (!priorityQueue.isEmpty()) {

            int node = priorityQueue.peek().node;
            int distance = priorityQueue.peek().distance;
            priorityQueue.remove();

            for (int i = 0; i < adj.get(node).size(); i++) {

                int edgeWeight = adj.get(node).get(i).distance;
                int adjNode = adj.get(node).get(i).node;

                if (distance + edgeWeight < dist.get(adjNode)) {

                    dist.set(adjNode, distance + edgeWeight);
                    priorityQueue.add(new Pair2(adjNode, dist.get(adjNode)));

                }

            }

        }

        return dist;

    }

    public static void main(String[] args) {

    }
}
