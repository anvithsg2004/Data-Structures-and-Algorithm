package DSA.Graphs._5_Minimum_Spanning_Tree;

public class _7_Number_of_operations_to_make_network_connected {
    public int makeConnected(int n, int[][] connections) {
        _5_Union_by_Size ds = new _5_Union_by_Size(n);
        int countExtras = 0;
        int m = connections.length;

        for (int i = 0; i < m; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            if (ds.findPar(u) == ds.findPar(v)) {
                countExtras++;
            } else {
                ds.unionByRank(u, v);
            }
        }

        int countC = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent.get(i) == i) {
                countC++;
            }
        }

        int ans = countC - 1;

        if (countExtras >= ans) {
            return ans;
        }

        return -1;
    }
}
