package DSA.Practice.DP.DP_Study_Plan.General_1D;

import java.util.Arrays;
import java.util.HashSet;

public class _2_Minimum_Cost_For_Tickets {

    //Recursion
    public int mincostTickets(int[] days, int[] costs) {


        //This is to put the days which are present in the "days" Array.
        HashSet<Integer> daysInDaysArray = new HashSet<>();

        //Add it to the daysInDaysArray Hashset.
        for (int num : days) {
            daysInDaysArray.add(num);
        }

        //Call the helper function
        //Here the "currentDay" is 1 because the days in the calendar starts from 1 to 365.
        return helper(days, costs, 1, daysInDaysArray);

    }

    public int helper(int[] days, int[] costs, int currentDay, HashSet<Integer> daysInDaysArray) {

        //The day exceeds the highest in the "days" array then return 0
        if (currentDay > days[days.length - 1]) {
            return 0;
        }

        //If you do not find the current day, then just keep going to the next day.
        if (!daysInDaysArray.contains(currentDay)) {
            return helper(days, costs, currentDay + 1, daysInDaysArray);
        }

        //This is the for the one-day pass,
        //so that's why add 1 to current day.
        int oneDayPass = costs[0] + helper(days, costs, currentDay + 1, daysInDaysArray);
        //This is the for the seven-day pass,
        //so that's why add 1 to current day.
        int sevenDayPass = costs[1] + helper(days, costs, currentDay + 1, daysInDaysArray);
        //This is the for the 30-day pass,
        //so that's why add 1 to current day.
        int thirtyDayPass = costs[2] + helper(days, costs, currentDay + 1, daysInDaysArray);

        //Get the minimum days required to go to the last day in the "days" array.
        return Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));

    }


    //Memoization
    public int mincostTickets2(int[] days, int[] costs) {

        HashSet<Integer> daysInDaysArray = new HashSet<>();

        for (int num : days) {
            daysInDaysArray.add(num);
        }

        int[] dp = new int[days[days.length - 1] + 1];

        Arrays.fill(dp, -1);

        return helper2(days, costs, 1, daysInDaysArray, dp);

    }

    public int helper2(int[] days, int[] costs, int currentDay, HashSet<Integer> daysInDaysArray, int[] dp) {

        if (currentDay > days[days.length - 1]) {
            return 0;
        }

        if (!daysInDaysArray.contains(currentDay)) {
            return helper2(days, costs, currentDay + 1, daysInDaysArray, dp);
        }

        if (dp[currentDay] != -1) {
            return dp[currentDay];
        }

        int oneDay = costs[0] + helper2(days, costs, currentDay + 1, daysInDaysArray, dp);
        int seventhDay = costs[1] + helper2(days, costs, currentDay + 7, daysInDaysArray, dp);
        int thirtiethDay = costs[2] + helper2(days, costs, currentDay + 30, daysInDaysArray, dp);

        return dp[currentDay] = Math.min(oneDay, Math.min(seventhDay, thirtiethDay));

    }


}
