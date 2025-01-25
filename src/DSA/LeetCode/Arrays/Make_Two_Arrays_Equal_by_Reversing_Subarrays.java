package DSA.LeetCode.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Make_Two_Arrays_Equal_by_Reversing_Subarrays {

    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }

        Arrays.sort(target);
        Arrays.sort(arr);

        return Arrays.equals(target, arr);
    }

    public boolean canBeEqual_2(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }

        Map<Integer, Integer> targetMap = new HashMap<>();
        Map<Integer, Integer> arrMap = new HashMap<>();

        for (int num : target) {
            targetMap.put(num, targetMap.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            arrMap.put(num, arrMap.getOrDefault(num, 0) + 1);
        }

        return targetMap.equals(arrMap);
    }

    public static void main(String[] args) {

    }
}
