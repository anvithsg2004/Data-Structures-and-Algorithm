package DSA.Dynamic_Programming.Recursion;

public class _3_M_Coloring {
    public boolean graphColoring(int v, int[][] edges, int m) {
        int[] color = new int[v];
        return solve(0, edges, color, m, v);
    }

    public boolean solve(int node, int[][] graph, int[] color, int m, int v) {

        if (node == v) {
            return true;
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(node, graph, color, m, v)) {
                color[node] = c;
                if (solve(node + 1, graph, color, m, v)) {
                    return true;
                }
                color[node] = 0;
            }
        }

        return false;

    }

    public boolean isSafe(int node, int[][] graph, int[] color, int c, int v) {

        for (int i = 0; i < v; i++) {
            if (graph[node][i] == 1 && color[i] == c) {
                return false;
            }
        }

        return true;
    }
}
