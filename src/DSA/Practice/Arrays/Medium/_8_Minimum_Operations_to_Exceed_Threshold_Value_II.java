package DSA.Practice.Arrays.Medium;

import java.util.PriorityQueue;

public class _8_Minimum_Operations_to_Exceed_Threshold_Value_II {
    public static int minOperations(int[] nums, int k) {

        if (nums.length <= 1) {
            return 0;
        }

        PriorityQueue<Long> minHeap = new PriorityQueue<>((a, b) -> Math.toIntExact(a - b));

        for (int num : nums) {
            minHeap.add((long) num);
        }

        int count = 0;

        while (true) {
            if (minHeap.size() < 2) {
                break;
            }

            Long firstElement = minHeap.poll();
            Long secondElement = minHeap.poll();

            if (firstElement >= k) {
                break;
            }

            Long formula = Math.min(firstElement, secondElement) * 2 + Math.max(firstElement, secondElement);

            minHeap.add(formula);

            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {999999999, 999999999, 999999999};
        int k = 1000000000;
        System.out.println(minOperations(nums, k));
    }

}
