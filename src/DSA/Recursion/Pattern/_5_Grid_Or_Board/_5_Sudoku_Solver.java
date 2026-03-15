package DSA.Recursion.Pattern._5_Grid_Or_Board;

public class _5_Sudoku_Solver {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {

                if (board[row][col] == '.') {

                    for (char num = '1'; num <= '9'; num++) {

                        if (isSafe(board, row, col, num)) {

                            // Choose
                            board[row][col] = num;

                            // Explore
                            if (solve(board)) {
                                return true;
                            }

                            // Undo
                            board[row][col] = '.';

                        }

                    }

                    return false;

                }

            }
        }

        return true;

    }

    public boolean isSafe(char[][] board, int row, int col, char num) {

        // row check
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num)
                return false;
        }

        // column check
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num)
                return false;
        }

        // 3x3 grid check
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num)
                    return false;
            }
        }

        return true;

    }

}
