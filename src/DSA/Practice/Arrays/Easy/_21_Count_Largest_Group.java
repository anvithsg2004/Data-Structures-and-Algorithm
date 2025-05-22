package DSA.Practice.Arrays.Easy;

import java.util.*;

//Input: n = 13
//Output: 4
//Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
//[1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9].
//There are 4 groups with the largest size.

//It is like if the index is 11 then by adding the index is 2;

public class _21_Count_Largest_Group {
    public int countLargestGroup(int n) {

        int[] result = new int[n];

        for (int i = 1; i <= n; i++) {

            String num = "" + i;

            int sum = 0;

            for (int j = 0; j < num.length(); j++) {
                sum = sum + Integer.parseInt(String.valueOf(num.charAt(j)));
            }

            result[sum - 1]++;
        }

        int maxiNumber = Arrays.stream(result).max().getAsInt();

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (maxiNumber == result[i]) {
                count++;
            }
        }

        return count;

    }
}
