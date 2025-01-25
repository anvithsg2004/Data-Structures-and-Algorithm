package DSA.Graphs._1_Learning;

public class _1_Graph_Representation_Matrix {
    public static void main(String[] args) {

        int n = 3;
        int m = 3;

        int[][] adj = new int[n + 1][m + 1];

        //Edge 1--2
        adj[1][2] = 1;
        adj[2][1] = 1;

        //Edge 2--3
        adj[2][3] = 1;
        adj[3][2] = 1;

        //Edge 1--3
        adj[1][3] = 1;
        adj[3][1] = 1;

        //Edge U--V
        int U = 0;
        int V = 1;
        adj[U][V] = 1;
        adj[V][U] = 1;

    }
}
