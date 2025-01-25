package DSA.Practice.Binary_Search.Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class _4_Maximum_Number_of_Groups_Entering_a_Competition {

    public boolean isItPossible(int[] grades, int noOfGroups) {

        int n = grades.length;
        int currentIndex = 0;

        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();

        // Try to form 'noOfGroups' groups with strictly increasing group sizes
        for (int groupSize = 1; groupSize <= noOfGroups; groupSize++) {
            ArrayList<Integer> subArrayList = new ArrayList<>();

            // Check if we have enough elements left for the current group
            if (currentIndex + groupSize > n) {
                return false;  // Not enough elements to form this group
            }

            // Add elements to the current group
            int count = 0;
            while (count < groupSize) {
                subArrayList.add(grades[currentIndex]);
                currentIndex++;
                count++;
            }

            // Add the current group to the groups list
            groups.add(subArrayList);
        }

        // If we successfully created the groups, return true
        return true;

    }

    public int maximumGroups(int[] grades) {

        Arrays.sort(grades);

        int n = grades.length;

        if (n == 1) {
            return 1;
        }

        int low = 1;
        int high = n - 1;

        int answer = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isItPossible(grades, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return answer;

    }

    public static void main(String[] args) {

    }
}
