package DSA.Practice.Greedy.Leetcode_Easy;

import java.util.Arrays;

public class _18_Apple_Redistribution_into_Boxes {
    public static int minimumBoxes(int[] apple, int[] capacity) {

        //First Sort the Array and then Reverse it.
        Arrays.sort(capacity);

        // Reverse the array manually
        for (int i = 0; i < capacity.length / 2; i++) {
            int temp = capacity[i];
            capacity[i] = capacity[capacity.length - 1 - i];
            capacity[capacity.length - 1 - i] = temp;
        }

        //Take the sum.
        int sum = 0;

        //Calculate the Sum.
        for (int i = 0; i < apple.length; i++) {
            sum = sum + apple[i];
        }

        System.out.println(sum);

        //Count the Amount of Capacity used.
        int count = 0;

        //Same to CalCalculate the sum.
        int remainingSum = sum;

        for (int i = 0; i < capacity.length; i++) {
            if (remainingSum <= 0) {
                break;
            }

            remainingSum = remainingSum - capacity[i];
            count++;

        }

        //Return the count.
        return count;

    }

    public static void main(String[] args) {
        int[] apple = {5, 8, 6};
        int[] capacity = {10, 5, 7, 6};

        minimumBoxes(apple, capacity);

    }
}
