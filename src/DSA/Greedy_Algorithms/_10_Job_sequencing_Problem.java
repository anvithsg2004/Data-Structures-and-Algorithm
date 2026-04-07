package DSA.Greedy_Algorithms;

import java.util.*;

class Job {
    int deadline;
    int profit;

    public Job(int deadline, int profit) {
        this.deadline = deadline;
        this.profit = profit;
    }

}

public class _10_Job_sequencing_Problem {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        int n = deadline.length;

        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(deadline[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (int d : deadline) {
            maxDeadline = Math.max(maxDeadline, d);
        }

        int[] slots = new int[maxDeadline + 1];
        Arrays.fill(slots, -1);

        int maxTakenJob = 0;
        int maxProfit = 0;

        for (Job job : jobs) {

            int currentDeadline = job.deadline;
            int currentProfit = job.profit;

            for (int i = currentDeadline; i > 0; i--) {
                if (slots[i] == -1) {
                    maxTakenJob = maxTakenJob + 1;
                    maxProfit = maxProfit + currentProfit;
                    slots[i] = 0;
                    break;
                }
            }

        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(maxTakenJob);
        result.add(maxProfit);

        return result;

    }
}
