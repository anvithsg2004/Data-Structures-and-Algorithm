package DSA.Recursion;

import java.util.*;

public class _1_N_Queens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solution = new ArrayList<>();
        char[][] board = new char[n][n];

        // initialize board
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        placeQueens(0, board, solution, n);
        return solution;
    }

    public void placeQueens(int row, char[][] board, List<List<String>> solution, int n) {

        if (row == n) {
            solution.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                placeQueens(row + 1, board, solution, n);
                board[row][col] = '.';
            }
        }

    }

    public boolean isSafe(char[][] board, int row, int col, int n) {

        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;

    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }

}
