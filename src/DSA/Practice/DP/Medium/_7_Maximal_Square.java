package DSA.Practice.DP.Medium;

public class _7_Maximal_Square {
    public int maximalSquare(char[][] inMatrix) {
        int m = inMatrix.length;
        int n = inMatrix[0].length;

        // Convert char matrix to int matrix
        int[][] matrix = new int[m][n];

        for (int i = 0; i < inMatrix.length; i++) {
            for (int j = 0; j < inMatrix[i].length; j++) {
                matrix[i][j] = Character.getNumericValue(inMatrix[i][j]);
            }
        }

        int[][] dp = new int[m][n];

        int maxiArea = 0;

        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
            maxiArea = Math.max(maxiArea, dp[i][0]);
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
            maxiArea = Math.max(maxiArea, dp[0][j]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    maxiArea = Math.max(maxiArea, dp[i][j]);
                }
            }
        }

        return maxiArea * maxiArea;
    }
}
