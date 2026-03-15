package DSA.Recursion.Pattern._5_Grid_Or_Board;

import java.util.*;

public class _4_N_Queens {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        for (char[] ch : board) {
            Arrays.fill(ch, '.');
        }

        backtrack(0, board, n, result);

        return result;

    }

    public void backtrack(int row, char[][] board, int n, List<List<String>> result) {

        if (row == n) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < board[0].length; col++) {

            if (isSafe(board, row, col, n)) {

                // Choose
                board[row][col] = 'Q';

                // Explore
                backtrack(row + 1, board, n, result);

                // Undo
                board[row][col] = '.';

            }

        }

    }

    public boolean isSafe(char[][] board, int row, int col, int n) {

        // Check Column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check Up Left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check Up Right
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;

    }

    public List<String> construct(char[][] board) {

        List<String> list = new ArrayList<>();

        for (char[] ch : board) {
            list.add(new String(ch));
        }

        return list;

    }

}
