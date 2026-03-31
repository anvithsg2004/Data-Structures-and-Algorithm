package DSA.Graphs._5_Minimum_Spanning_Tree;

public class _7_Number_of_operations_to_make_network_connected {
    public int makeConnected(int n, int[][] connections) {

        if (connections.length < n - 1) {
            return -1;
        }

        DisjoinSet ds = new DisjoinSet(n);

        for (int[] edge : connections) {
            ds.union(edge[0], edge[1]);
        }

        int components = 0;

        for (int i = 0; i < n; i++) {
            if (ds.find(i) == i) {
                components++;
            }
        }

        return components - 1;

    }

    class DisjoinSet {

        int[] parent;
        int[] rank;

        public DisjoinSet(int n) {

            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }

        }

        public int find(int node) {

            if (node == parent[node]) {
                return node;
            }

            return parent[node] = find(parent[node]);

        }

        public void union(int u, int v) {

            int pu = find(u);
            int pv = find(v);

            if (pu == pv) {
                return;
            }

            if (rank[pu] < rank[pv]) {
                parent[pu] = pv;
            } else if (rank[pv] < rank[pu]) {
                parent[pv] = pu;
            } else {
                parent[pv] = pu;
                rank[pu]++;
            }

        }

    }
}
