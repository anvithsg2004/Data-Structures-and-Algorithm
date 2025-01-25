package DSA.LeetCode.Graphs;

import java.util.HashMap;
import java.util.Map;

public class Find_Center_of_Star_Graph {

    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            map.put(u, map.getOrDefault(u, 0) + 1);
            map.put(v, map.getOrDefault(v, 0) + 1);
        }

        int center = -1;
        int maxDegree = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxDegree) {
                maxDegree = entry.getValue();
                center = entry.getKey();
            }
        }

        return center;
    }

    public static void main(String[] args) {

    }
}
