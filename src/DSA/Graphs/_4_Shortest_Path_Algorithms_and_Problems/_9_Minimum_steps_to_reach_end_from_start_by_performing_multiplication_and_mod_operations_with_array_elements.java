package DSA.Graphs._4_Shortest_Path_Algorithms_and_Problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair8 {
    int steps;
    int numbers;

    public Pair8(int steps, int numbers) {
        this.steps = steps;
        this.numbers = numbers;
    }
}

public class _9_Minimum_steps_to_reach_end_from_start_by_performing_multiplication_and_mod_operations_with_array_elements {
    public int minimumMultiplications(int[] arr, int start, int end) {

        if (start == end) {
            return 0;
        }

        Queue<Pair8> queue = new LinkedList<>();
        queue.add(new Pair8(0, start));

        int[] distances = new int[100000];
        Arrays.fill(distances, (int) 1e9);

        distances[start] = 0;

        int mod = 100000;
        int n = arr.length;

        while (!queue.isEmpty()) {

            int node = queue.peek().numbers;
            int steps = queue.peek().steps;
            queue.remove();

            for (int i = 0; i < n; i++) {
                int num = (arr[i] * node) % mod;

                if (steps + 1 < distances[num]) {
                    distances[num] = steps + 1;

                    if (num == end) {
                        return steps + 1;
                    }

                    queue.add(new Pair8(steps + 1, num));
                }
            }

        }

        return -1;
    }
}
