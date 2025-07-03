package DSA.LLD._4_Problems._2_Chess_Game.Strategy;

import DSA.LLD._4_Problems._2_Chess_Game.Board.Board;
import DSA.LLD._4_Problems._2_Chess_Game.Board.Cell;
import DSA.LLD._4_Problems._2_Chess_Game.Pieces.Piece;

public class PawnMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        Piece piece = startCell.getPiece();
        if (piece == null) return false;

        int direction = piece.isWhite() ? -1 : 1;
        int rowDiff = endCell.getRow() - startCell.getRow();
        int colDiff = Math.abs(endCell.getCol() - startCell.getCol());

        // Forward move (no capture)
        if (colDiff == 0 && rowDiff == direction && endCell.getPiece() == null) {
            return true;
        }

        // Diagonal capture
        if (colDiff == 1 && rowDiff == direction && endCell.getPiece() != null && endCell.getPiece().isWhite() != piece.isWhite()) {
            return true;
        }

        return false;
    }
}
