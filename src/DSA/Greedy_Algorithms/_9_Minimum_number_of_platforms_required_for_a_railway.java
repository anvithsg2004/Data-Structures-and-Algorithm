package DSA.Greedy_Algorithms;

import java.util.Arrays;

public class _9_Minimum_number_of_platforms_required_for_a_railway {
    public int minPlatform(int[] arr, int[] dep) {

        int n = arr.length;

        Arrays.sort(arr);
        Arrays.sort(dep);

        int platform = 0;
        int maxPlatformNeeded = 0;

        int i = 0;
        int j = 0;

        while (i < arr.length && j < dep.length) {

            if (arr[i] <= dep[j]) {
                platform++;
                i++;
            } else {
                platform--;
                j++;
            }

            maxPlatformNeeded = Math.max(maxPlatformNeeded, platform);

        }

        return maxPlatformNeeded;

    }
}
