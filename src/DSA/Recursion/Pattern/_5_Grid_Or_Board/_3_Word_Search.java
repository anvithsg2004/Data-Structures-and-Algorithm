package DSA.Recursion.Pattern._5_Grid_Or_Board;

public class _3_Word_Search {
    public boolean exist(char[][] board, String word) {

        int n = word.length();

        int row = board.length;
        int col = board[0].length;

        int[] rowDir = {-1, 1, 0, 0};
        int[] colDir = {0, 0, -1, 1};

        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (board[i][j] == word.charAt(0)) {

                    visited[i][j] = true;

                    if (help(1, board, word, i, j, rowDir, colDir, visited)) {
                        return true;
                    }

                    visited[i][j] = false;

                }

            }
        }

        return false;

    }

    public boolean help(int index, char[][] board, String word, int row, int col, int[] rowDir, int[] colDir, boolean[][] visited) {

        if (index == word.length()) {
            return true;
        }

        for (int i = 0; i < 4; i++) {

            int newRow = row + rowDir[i];
            int newCol = col + colDir[i];

            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length && board[newRow][newCol] == word.charAt(index) && !visited[newRow][newCol]) {

                // Choose
                visited[newRow][newCol] = true;

                // Explore
                if (help(index + 1, board, word, newRow, newCol, rowDir, colDir, visited)) {
                    return true;
                }

                // Undo
                visited[newRow][newCol] = false;

            }

        }

        return false;

    }

}
