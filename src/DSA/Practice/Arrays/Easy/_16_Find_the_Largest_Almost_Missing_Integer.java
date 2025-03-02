package DSA.Practice.Arrays.Easy;

import java.util.ArrayList;
import java.util.Arrays;

public class _16_Find_the_Largest_Almost_Missing_Integer {
    public static int largestInteger(int[] nums, int k) {

        int n = nums.length;

        ArrayList<ArrayList<Integer>> subArrays = new ArrayList<>();

        for (int i = 0; i <= n - k; i++) {
            ArrayList<Integer> sub = new ArrayList<>();
            for (int j = i; j < i + k; j++) {
                sub.add(nums[j]);
            }
            subArrays.add(sub);
        }

        subArrays.forEach(System.out::println);

        //Sort the given Array
        Arrays.sort(nums);

        int subArrayLength = subArrays.size();

        int[] countFreq = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < subArrayLength; j++) {
                if (subArrays.get(j).contains(nums[i])) {
                    count++;
                }
            }
            countFreq[i] = count;
        }

        System.out.println(Arrays.toString(countFreq));

        int maxNumber = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (countFreq[i] < minFreq || (countFreq[i] == minFreq && nums[i] > maxNumber)) {
                minFreq = countFreq[i];
                maxNumber = nums[i];
            }
        }

        return (minFreq < subArrayLength) ? maxNumber : -1;

    }

    public static void main(String[] args) {
        int[] nums = {3, 9, 2, 1, 7};
        int k = 3;
        largestInteger(nums, k);
    }
}
