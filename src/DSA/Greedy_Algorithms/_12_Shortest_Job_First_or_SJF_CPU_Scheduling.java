package DSA.Greedy_Algorithms;

import java.util.*;

public class _12_Shortest_Job_First_or_SJF_CPU_Scheduling {
    public int solve(int[] bt) {

        int n = bt.length;

        Arrays.sort(bt);

        int waitingTime = 0;
        int totalWaitingTime = 0;

        for (int i = 0; i < n; i++) {
            totalWaitingTime = totalWaitingTime + waitingTime;
            waitingTime = waitingTime + bt[i];
        }

        return totalWaitingTime / n;

    }
}
