package DSA.Dynamic_Programming._4_Subsequences;

public class _11_Rod_Cutting {
    public int cutRod(int[] price) {
        int n = price.length;

        int[] lengths = new int[n];
        for (int i = 0; i < n; i++) {
            lengths[i] = i + 1;
        }

        return helper(n - 1, price, lengths, n);
    }

    public int helper(int index, int[] price, int[] lengths, int remainingLength) {
        if (index == 0) {
            return remainingLength * price[index];
        }

        int notTaken = helper(index - 1, price, lengths, remainingLength);

        int taken = Integer.MIN_VALUE;

        if (lengths[index] <= remainingLength) {
            taken = price[index] + helper(index, price, lengths, remainingLength - lengths[index]);
        }

        return Math.max(notTaken, taken);
    }
}
