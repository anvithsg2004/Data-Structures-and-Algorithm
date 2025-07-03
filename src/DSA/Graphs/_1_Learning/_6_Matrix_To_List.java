package DSA.Graphs._1_Learning;

import java.util.ArrayList;
import java.util.List;

class DirectedGraphConverter {

    public static List<List<Integer>> matrixToListDirected(int[][] matrix) {
        int n = matrix.length;
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    adjList.get(i).add(j);
                }
            }
        }

        return adjList;
    }
}

class UndirectedGraphConverter {

    public static List<List<Integer>> matrixToListUndirected(int[][] matrix) {
        int n = matrix.length;
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    adjList.get(i).add(j);
                    if (i != j) {
                        adjList.get(j).add(i); // Avoid duplicating self-loops
                    }
                }
            }
        }

        return adjList;
    }

}
