package DSA.LeetCode.Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Sort_the_Jumbled_Numbers {

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] transformedNums = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            String numberStr = String.valueOf(nums[i]);
            StringBuilder transformedStr = new StringBuilder();

            for (int j = 0; j < numberStr.length(); j++) {
                int originalDigit = Character.getNumericValue(numberStr.charAt(j));
                transformedStr.append(mapping[originalDigit]);
            }

            transformedNums[i] = Integer.parseInt(transformedStr.toString());
        }

        Integer[] indexArray = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexArray[i] = i;
        }

//        Arrays.sort(indexArray, Comparator.comparingInt(a -> transformedNums[a]));
        Arrays.sort(indexArray, (a, b) -> Integer.compare(transformedNums[a], transformedNums[b]));

        int[] sortedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sortedNums[i] = nums[indexArray[i]];
        }

        return sortedNums;
    }

    public static void main(String[] args) {

    }
}
