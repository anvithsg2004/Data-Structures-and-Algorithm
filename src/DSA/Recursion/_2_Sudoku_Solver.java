package DSA.Recursion;

public class _2_Sudoku_Solver {
    public boolean solveSudoku(char[][] board) {

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }

                    return false;
                }

            }
        }

        return true;

    }

    public boolean isValid(char[][] board, int row, int col, char c) {

        for (int i = 0; i < 9; i++) {

            if (board[row][i] == c) {
                return false;
            }

            if (board[i][col] == c) {
                return false;
            }

            int subRow = 3 * (row / 3) + (i / 3);
            int subCol = 3 * (col / 3) + (i % 3);

            if (board[subRow][subCol] == c) {
                return false;
            }

        }

        return true;

    }
}
