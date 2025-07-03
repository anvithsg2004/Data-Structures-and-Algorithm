package DSA.LLD._4_Problems._2_Chess_Game.Strategy;

import DSA.LLD._4_Problems._2_Chess_Game.Board.Board;
import DSA.LLD._4_Problems._2_Chess_Game.Board.Cell;

public class RookMovementStrategy implements MovementStrategy {
    @Override
    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        int rowDiff = Math.abs(endCell.getRow() - startCell.getRow());
        int colDiff = Math.abs(endCell.getCol() - startCell.getCol());
        return rowDiff == 0 || colDiff == 0; // horizontal or vertical
    }
}
