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

        //Sort jobs in decreasing order of profit since we want to maximize profit.
        //Find the maximum deadline among all jobs to determine the size of the schedule.
        //Iterate through the sorted jobs and place each job in the latest available time slot before its deadline.
        //Keep track of the total profit and the number of jobs scheduled.

        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

        //Job ID | Deadline | Profit
        //--------------------------
        //  1    |    2    |  100
        //  2    |    1    |   50
        //  5    |    3    |   30
        //  4    |    1    |   20
        //  3    |    2    |   10

        int maxi = 0;

        //Step 2: Find Maximum Deadline
        //The maximum deadline among all jobs is 3.
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxi) {
                maxi = arr[i].deadline;
            }
        }

        //result = [-1, -1, -1, -1]
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

//Time Complexity
//Sorting jobs: O(n log n)
//Finding max deadline: O(n)
//Placing jobs in the schedule: O(n * d), where d is the max deadline (worst case)
//Thus, overall complexity is O(n log n + n * d).
//For small deadlines, it is nearly O(n log n), which is efficient.
