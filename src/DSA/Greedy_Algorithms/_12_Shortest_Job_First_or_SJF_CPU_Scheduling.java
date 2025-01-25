package DSA.Greedy_Algorithms;

import java.util.Arrays;

public class _12_Shortest_Job_First_or_SJF_CPU_Scheduling {
    public int solve(int[] bt) {

        Arrays.sort(bt);

        int n = bt.length;

        float waitingTime = 0;
        int totalTime = 0;

        for (int i = 0; i < n; i++) {

            waitingTime = waitingTime + totalTime;

            totalTime = totalTime + bt[i];

        }

        return (int) (waitingTime / n);

    }
}
