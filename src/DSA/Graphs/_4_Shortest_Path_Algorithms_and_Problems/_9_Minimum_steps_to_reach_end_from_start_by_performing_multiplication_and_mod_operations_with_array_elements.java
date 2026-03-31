package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems;

import java.util.*;

public class _9_Minimum_steps_to_reach_end_from_start_by_performing_multiplication_and_mod_operations_with_array_elements {
    public int minimumMultiplications(int[] arr, int start, int end) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});

        int[] dist = new int[100000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int num = current[0];
            int steps = current[1];

            if (num == end) {
                return steps;
            }

            for (int x : arr) {

                int newNum = (num * x) % 100000;

                if (steps + 1 < dist[newNum]) {
                    dist[newNum] = steps + 1;
                    queue.add(new int[]{newNum, steps + 1});
                }

            }

        }

        return -1;

    }
}
