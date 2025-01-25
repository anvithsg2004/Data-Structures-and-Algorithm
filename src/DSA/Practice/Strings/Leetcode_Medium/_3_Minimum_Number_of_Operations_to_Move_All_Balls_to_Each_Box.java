package DSA.Practice.Strings.Leetcode_Medium;

import java.util.ArrayList;
import java.util.Map;

public class _3_Minimum_Number_of_Operations_to_Move_All_Balls_to_Each_Box {

    public int[] minOperations(String boxes) {

        int n = boxes.length();
        int[] answer = new int[n];

        // Calculate operations for each box
        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && boxes.charAt(j) == '1') {
                    sum += Math.abs(i - j); // Count moves needed
                }
            }

            answer[i] = sum; // Directly assign to answer array
        }

        return answer; // Return the result

    }

    public static void main(String[] args) {

    }
}
