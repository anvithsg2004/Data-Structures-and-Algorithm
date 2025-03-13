package DSA.Graphs._3_Topo_Sort;

//It exists only on DAG (Directed Acyclic Graph)
//Definition → Linear Ordering of the vertices such that if there is an
//edge between u and v, then u appears before v in the ordering.

//Example :-
//5 -> 0
//4 -> 0
//5 -> 2
//2 -> 3
//3 -> 1
//4 -> 1

//The Topo Sort order is 5 4 2 3 1 0

import java.util.ArrayList;
import java.util.Stack;

public class _1_Topo_Sort {

    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        int n = adj.size();

        boolean[] visited = new boolean[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            if (visited[i] == false) {
                dfs(i, visited, stack, adj);
            }

        }

        ArrayList<Integer> result = new ArrayList<>();

        int index = 0;

        while (!stack.isEmpty()) {
            result.add(index, stack.peek());
            index++;
            stack.pop();
        }

        return result;
    }

    public static void dfs(int node, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {

        visited[node] = true;

        for (int it : adj.get(node)) {
            if (visited[it] == false) {
                dfs(it, visited, stack, adj);
            }
        }

        stack.push(node);

    }
}
