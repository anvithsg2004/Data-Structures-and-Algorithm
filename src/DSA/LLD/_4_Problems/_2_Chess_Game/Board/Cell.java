package DSA.LLD._4_Problems._2_Chess_Game.Board;

import DSA.LLD._4_Problems._2_Chess_Game.Pieces.Piece;

public class Cell {
    private int row;
    private int col;
    private Piece piece;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.piece = null;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isValid() {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    public void startCell() {
        // Placeholder for start cell logic
    }

    public void endCell() {
        // Placeholder for end cell logic
    }
}
