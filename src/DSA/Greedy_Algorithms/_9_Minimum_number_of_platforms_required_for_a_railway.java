package DSA.Greedy_Algorithms;

import java.util.Arrays;

public class _9_Minimum_number_of_platforms_required_for_a_railway {
    public int findPlatform(int[] arr, int[] dep) {

        int n = arr.length;

        Arrays.sort(arr);
        Arrays.sort(dep);

        int platformNeeded = 1;
        int result = 1;
        int i = 1;
        int j = 0;

        while (i < n && j < n) {

            if (arr[i] <= dep[j]) {
                platformNeeded = platformNeeded + 1;
                i = i + 1;
            } else if (arr[i] > dep[j]) {
                platformNeeded = platformNeeded - 1;
                j = j + 1;
            }

            if (platformNeeded > result) {
                result = platformNeeded;
            }

        }

        return result;

    }
}
