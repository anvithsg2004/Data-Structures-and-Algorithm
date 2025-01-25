package DSA.Greedy_Algorithms;

import java.util.Arrays;

class Job {
    int id;
    int deadline;
    int profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class _10_Job_sequencing_Problem {
    public int[] JobScheduling(Job[] arr, int n) {
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

        int maxi = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxi) {
                maxi = arr[i].deadline;
            }
        }

        int[] result = new int[maxi + 1];
        Arrays.fill(result, -1);

        int countJobs = 0;
        int jobProfits = 0;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {
                if (result[j] == -1) {
                    result[j] = i;
                    countJobs = countJobs + 1;
                    jobProfits = jobProfits + arr[i].profit;
                    break;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = countJobs;
        answer[1] = jobProfits;
        return answer;

    }
}
