package DSA.Dynamic_Programming._4_Subsequences;

public class _9_0_1_Knapsack {

    // Recursion
    public int knapsack(int[] weights, int[] values, int maxWeight) {
        int n = weights.length;
        return helper(n - 1, maxWeight, weights, values);
    }

    private int helper(int index, int maxWeight, int[] weight, int[] values) {
        // Base case
        if (index == 0) {
            // Can only take if it fits
            return (weight[0] <= maxWeight) ? values[0] : 0;
        }

        // Not take the current item
        int notTaken = helper(index - 1, maxWeight, weight, values);

        // Take the current item (if it fits)
        int taken = Integer.MIN_VALUE;
        if (weight[index] <= maxWeight) {
            taken = values[index]
                    + helper(index - 1,
                    maxWeight - weight[index], weight, values);
        }

        // We want the maximum of these two
        return Math.max(notTaken, taken);
    }
}
