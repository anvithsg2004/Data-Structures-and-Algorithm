package DSA.Dynamic_Programming.Recursion;

import java.util.*;

public class _1_N_Queens {
    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        for (char[] ch : board) {
            Arrays.fill(ch, '.');
        }

        List<List<String>> result = new ArrayList<>();

        placeQueens(board, 0, result, n);

        return result;

    }

    public void placeQueens(char[][] board, int row, List<List<String>> result, int n) {

        if (row == n) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                placeQueens(board, row + 1, result, n);
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col, int n) {

        // Same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Upper Left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Upper Right
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;

    }

    public List<String> construct(char[][] board) {
        List<String> path = new ArrayList<>();
        for (char[] row : board) {
            path.add(new String(row));
        }
        return path;
    }
}
