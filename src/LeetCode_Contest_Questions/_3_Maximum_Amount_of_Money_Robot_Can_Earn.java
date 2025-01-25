package LeetCode_Contest_Questions;

public class _3_Maximum_Amount_of_Money_Robot_Can_Earn {

    //Recursion
    public int maximumAmount(int[][] coins) {
        int neutralize = 2; // The robot can neutralize up to 2 robbers
        return helper(coins, 0, 0, neutralize);
    }

    private int helper(int[][] coins, int row, int col, int neutralize) {
        int m = coins.length;
        int n = coins[0].length;

        // Base case: If the robot reaches the bottom-right corner
        if (row == m - 1 && col == n - 1) {
            if (coins[row][col] < 0 && neutralize > 0) {
                return 0; // Neutralize the robber
            }
            return coins[row][col];
        }

        // Check for out-of-bounds indices
        if (row >= m || col >= n) {
            return Integer.MIN_VALUE; // Invalid path
        }

        // Recursive case: Move right or down
        int right = helper(coins, row, col + 1, neutralize);
        int down = helper(coins, row + 1, col, neutralize);

        // Compute maximum profit from the right and down paths
        int maxPath = Math.max(right, down);

        // Calculate the result for different scenarios
        int withoutNeutralization = coins[row][col] + maxPath;
        int withNeutralization = Integer.MIN_VALUE;

        if (coins[row][col] < 0 && neutralize > 0) {
            withNeutralization = 0 +
                    Math.max(helper(coins, row, col + 1, neutralize - 1),
                            helper(coins, row + 1, col, neutralize - 1));
        }

        // Return the maximum possible value
        return Math.max(withoutNeutralization, withNeutralization);
    }

    //Memoization
    public int maximumAmount1(int[][] coins) {
        int neutralize = 2; // The robot can neutralize up to 2 robbers
        int m = coins.length;
        int n = coins[0].length;

        // Initialize a 3D memoization array
        // memo[row][col][neutralize] stores the result for helper(row, col, neutralize)
        int[][][] memo = new int[m][n][neutralize + 1];

        // Fill the memo array with a placeholder value (e.g., -1) to indicate uncomputed states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= neutralize; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }

        return helper(coins, 0, 0, neutralize, memo);
    }

    private int helper(int[][] coins, int row, int col, int neutralize, int[][][] memo) {
        int m = coins.length;
        int n = coins[0].length;

        // Base case: If the robot reaches the bottom-right corner
        if (row == m - 1 && col == n - 1) {
            if (coins[row][col] < 0 && neutralize > 0) {
                return 0; // Neutralize the robber
            }
            return coins[row][col];
        }

        // Check for out-of-bounds indices
        if (row >= m || col >= n) {
            return Integer.MIN_VALUE; // Invalid path
        }

        // If the result is already computed, return it from the memo
        if (memo[row][col][neutralize] != -1) {
            return memo[row][col][neutralize];
        }

        // Recursive case: Move right or down
        int right = helper(coins, row, col + 1, neutralize, memo);
        int down = helper(coins, row + 1, col, neutralize, memo);

        // Compute maximum profit from the right and down paths
        int maxPath = Math.max(right, down);

        // Calculate the result for different scenarios
        int withoutNeutralization = coins[row][col] + maxPath;
        int withNeutralization = Integer.MIN_VALUE;

        if (coins[row][col] < 0 && neutralize > 0) {
            withNeutralization = 0 +
                    Math.max(helper(coins, row, col + 1, neutralize - 1, memo),
                            helper(coins, row + 1, col, neutralize - 1, memo));
        }

        // Compute the result for the current state
        int result = Math.max(withoutNeutralization, withNeutralization);

        // Store the result in the memo before returning
        memo[row][col][neutralize] = result;
        return result;
    }
}
