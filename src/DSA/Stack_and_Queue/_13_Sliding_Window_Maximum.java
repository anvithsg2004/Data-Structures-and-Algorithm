package DSA.Stack_and_Queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _13_Sliding_Window_Maximum {

    public int[] maxSlidingWindow2(int[] nums, int k) {

        int n = nums.length;

        List<Integer> list = new ArrayList<>();
        //This Deque will be storing only index.
        //Here we are maintaining decreasing monotonic stack.
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1 && !deque.isEmpty()) {
                list.add(nums[deque.peekFirst()]);
            }

        }

        int[] result = new int[list.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;

    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        List<Integer> list = new ArrayList<>();

        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < n - k; i++) {

            maxi = nums[i];

            for (int j = i; j < i + k - 1; j++) {
                maxi = Math.max(maxi, nums[j]);
            }

            list.add(maxi);

        }

        int size = list.size();

        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = list.get(i);
        }

        return result;

    }
}
