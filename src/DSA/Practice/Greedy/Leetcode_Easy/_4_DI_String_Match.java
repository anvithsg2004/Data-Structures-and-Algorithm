package DSA.Practice.Greedy.Leetcode_Easy;

import java.util.Arrays;

public class _4_DI_String_Match {
    public static int[] diStringMatch(String s) {

        int n = s.length();

        int[] result = new int[n + 1];

        int smallest = 0;
        int largest = n;

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == 'I') {
                result[i] = smallest;
                smallest = smallest + 1;
            } else if (s.charAt(i) == 'D') {
                result[i] = largest;
                largest = largest - 1;
            }

        }

        result[n] = largest;

        return result;

    }

    public static void main(String[] args) {
        String s = "IDID";
        System.out.println(Arrays.toString(diStringMatch(s)));
    }
}
