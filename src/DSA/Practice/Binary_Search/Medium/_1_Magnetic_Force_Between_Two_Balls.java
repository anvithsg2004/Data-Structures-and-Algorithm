package DSA.Practice.Binary_Search.Medium;

import java.util.Arrays;

public class _1_Magnetic_Force_Between_Two_Balls {

    public boolean isAllocationPossible(int minDist, int[] position, int m) {
        int n = position.length;

        int noOfBallsPlaced = 1;
        int lastBallPlacePosition = position[0];

        for (int i = 0; i < n; i++) {

            if (position[i] - lastBallPlacePosition >= minDist) {
                noOfBallsPlaced++;
                lastBallPlacePosition = position[i];
            }

            if (noOfBallsPlaced >= m) {
                return true;
            }

        }

        return false;

    }

    public int maxDistance(int[] position, int m) {

        //Find the Maximum and Minimum distance possible.
        //The Maximum distance is When we keep the basket one in the first and one in the last.(largest value - smallest value)
        //The Minimum distance is when we keep the basket one after one till the last.
        //Then my answer lies between the max and min.
        //This is monotonic sequence means imagine if from start it is coming true then once if it comes false then the next all will come as false.

        int n = position.length;

        if (m > n) {
            return -1;
        }


        Arrays.sort(position);

        int low = 1;//Minimum

        int high = position[n - 1] - position[0];//Maximum

        int answer = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isAllocationPossible(mid, position, m)) {
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
