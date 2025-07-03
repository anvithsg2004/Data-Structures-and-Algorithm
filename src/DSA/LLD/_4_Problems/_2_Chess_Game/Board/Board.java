package DSA.LLD._4_Problems._2_Chess_Game.Board;

public class Board {
    private Cell[][] board;
    private static Board instance;

    private Board() {
        board = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Cell(i, j);
            }
        }
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    public Cell getCell(int row, int col) {
        if (row >= 0 && row < 8 && col >= 0 && col < 8) {
            return board[row][col];
        }
        return null;
    }

    public void setPawnRow(int row, int col, boolean isWhite) {
        // Placeholder for setting pawn row
    }
}
