package Top_150;

public class _14_Game_of_Life {
    //🔧 Problem Breakdown:
    //You're given an m x n grid (2D board) with:
    //
    //1 = live cell
    //0 = dead cell
    //Apply the 4 rules to all cells simultaneously to compute the next state.

    //🔄 Game of Life Rules:
    //Underpopulation: Live cell with <2 live neighbors → dies (1 → 0)
    //Survival: Live cell with 2 or 3 live neighbors → lives (1 → 1)
    //Overpopulation: Live cell with >3 live neighbors → dies (1 → 0)
    //Reproduction: Dead cell with exactly 3 live neighbors → becomes live (0 → 1)

    //🧠 Smart Trick – Use Encoded States:
    //Instead of using just 0 and 1, we temporarily use:
    //2 → cell was live (1) → will become dead (0)
    //3 → cell was dead (0) → will become live (1)
    //This way, you remember the original state during processing.

    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                // Count live neighbors
                for (int k = 0; k < 8; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                        if (board[ni][nj] == 1 || board[ni][nj] == 2) {
                            liveNeighbors++;
                        }
                    }
                }

                // Apply rules and encode changes
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 2; // live → dead
                }
                if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 3; // dead → live
                }
            }
        }

        // Finalize the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) board[i][j] = 0;
                if (board[i][j] == 3) board[i][j] = 1;
            }
        }
    }
}
