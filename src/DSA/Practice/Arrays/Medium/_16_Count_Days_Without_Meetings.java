package DSA.Practice.Arrays.Medium;

public class _16_Count_Days_Without_Meetings {

    //Brute Force
    public int countDays(int days, int[][] meetings) {

        int[] daysAvailable = new int[days + 1];

        for (int i = 0; i < meetings.length; i++) {
            for (int j = meetings[i][0]; j <= meetings[i][1]; j++) {
                daysAvailable[j] = 1;
            }
        }

        int count = 0;

        for (int i = 1; i < daysAvailable.length; i++) {
            if (daysAvailable[i] == 0) {
                count++;
            }
        }

        return count;

    }

    //Better Solution
    public int countDays2(int days, int[][] meetings) {

        for (int i = 0; i < meetings.length; i++) {
            days = days - (meetings[i][1] - meetings[i][0]);
        }

        return days;

    }
}
