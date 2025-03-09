package DSA.Dynamic_Programming._4_Subsequences;

//In the previous problem, there was only one supply of values,
//but here there is infinite number of values provided.
//Same like the coin 2 problem in this package.

public class _10_Unbounded_Knapsack {

    public int unboundedKnapsack(int[] values, int[] weights, int maxWeights) {
        int n = weights.length;
        return helper(n - 1, values, weights, maxWeights);
    }

    public int helper(int index, int[] values, int[] weights, int maxWeight) {

        if (index == 0) {
            return (int) (maxWeight / weights[index]) * values[index];
        }

        int notTaken = helper(index - 1, values, weights, maxWeight);

        int taken = Integer.MIN_VALUE;

        if (weights[index] <= maxWeight) {
            taken = values[index] + helper(index, values, weights, maxWeight - weights[index]);
        }

        return Math.max(notTaken, taken);

    }
}
