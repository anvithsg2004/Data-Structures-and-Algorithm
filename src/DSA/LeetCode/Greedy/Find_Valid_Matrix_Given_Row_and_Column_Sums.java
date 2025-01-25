package DSA.LeetCode.Greedy;

public class Find_Valid_Matrix_Given_Row_and_Column_Sums {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rLenght = rowSum.length;
        int cLenght = colSum.length;
        int[][] finalMatrix = new int[rLenght][cLenght];

        for (int i = 0; i < rLenght; i++) {
            for (int j = 0; j < cLenght; j++) {
                if (rowSum[i] != 0 && colSum[j] != 0) {
                    finalMatrix[i][j] = Math.min(rowSum[i], colSum[j]);
                    rowSum[i] = rowSum[i] - finalMatrix[i][j];
                    colSum[j] = colSum[j] - finalMatrix[i][j];
                }
                else {
                    finalMatrix[i][j] = 0;
                }
            }
        }

        return finalMatrix;
    }

    public static void main(String[] args) {

    }
}
