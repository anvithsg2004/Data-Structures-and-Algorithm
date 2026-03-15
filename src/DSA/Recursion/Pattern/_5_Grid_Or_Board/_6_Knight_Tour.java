package DSA.Recursion.Pattern._5_Grid_Or_Board;

import java.util.*;

public class _6_Knight_Tour {
    public ArrayList<ArrayList<Integer>> knightTour(int n) {

        int[][] board = new int[n][n];

        for (int[] arr : board) {
            Arrays.fill(arr, -1);
        }

        int[] rowMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] colMove = {1, 2, 2, 1, -1, -2, -2, -1};

        board[0][0] = 0;

        boolean possible = solve(0, 0, 1, n, board, rowMove, colMove);

        if (possible == false) {
            return new ArrayList<>(); // or return board depending on problem requirement
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(board[i][j]);
            }
            result.add(row);
        }

        return result;

    }

    public boolean solve(int row, int col, int move, int n, int[][] board, int[] rowMove, int[] colMove) {

        if (move == n * n) {
            return true;
        }

        for (int i = 0; i < 8; i++) {

            int newRow = row + rowMove[i];
            int newCol = col + colMove[i];

            if (isSafe(newRow, newCol, n, board)) {

                // Choose
                board[newRow][newCol] = move;

                // Explore
                if (solve(newRow, newCol, move + 1, n, board, rowMove, colMove)) {
                    return true;
                }

                // Undo
                board[newRow][newCol] = -1;

            }

        }

        return false;

    }

    public boolean isSafe(int row, int col, int n, int[][] board) {

        return row >= 0 && row < n && col >= 0 && col < n && board[row][col] == -1;

    }
}
