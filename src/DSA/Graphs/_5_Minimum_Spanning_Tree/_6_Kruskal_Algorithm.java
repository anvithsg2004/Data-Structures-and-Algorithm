package DSA.Graphs._5_Minimum_Spanning_Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge implements Comparable<Edge> {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

public class _6_Kruskal_Algorithm {
    public static int spanningTree(int v, int e, List<List<int[]>> adj) {

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j)[0];
                int weight = adj.get(i).get(j)[1];
                int node = i;
                Edge temp = new Edge(i, adjNode, weight);
                edges.add(temp);
            }
        }

        _4_Union_by_Rank ds = new _4_Union_by_Rank(v);

        Collections.sort(edges);

        int mstWt = 0;

        for (int i = 0; i < edges.size(); i++) {
            int wt = edges.get(i).weight;
            int u = edges.get(i).source;
            int v_ = edges.get(i).destination;

            if (ds.findPar(u) != ds.findPar(v_)) {
                mstWt = mstWt + wt;
                ds.unionByRank(u, v_);
            }
        }

        return mstWt;

    }
}
