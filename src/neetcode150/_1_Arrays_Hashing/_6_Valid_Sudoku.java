package neetcode150._1_Arrays_Hashing;

public class _6_Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {

        int rowLength = board.length;
        int colLength = board[0].length;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (board[i][j] != '.' && helper(board, i, j) == false) {
                    return false;
                }
            }
        }

        return true;

    }

    public boolean helper(char[][] board, int i, int j) {

        int currentNumber = board[i][j];

        // Row check
        for (int col = 0; col < 9; col++) {
            if (col != j && board[i][col] == currentNumber) {
                return false;
            }
        }

        // Column check
        for (int row = 0; row < 9; row++) {
            if (row != i && board[row][j] == currentNumber) {
                return false;
            }
        }

        // 3x3 grid check
        int startRow = (i / 3) * 3;
        int startCol = (j / 3) * 3;

        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                if ((row != i || col != j) && board[row][col] == currentNumber) {
                    return false;
                }
            }
        }

        return true;
    }

}
