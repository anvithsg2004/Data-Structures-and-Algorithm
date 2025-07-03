package DSA.LLD._4_Problems._2_Chess_Game.Pieces;

import DSA.LLD._4_Problems._2_Chess_Game.Board.Board;
import DSA.LLD._4_Problems._2_Chess_Game.Board.Cell;
import DSA.LLD._4_Problems._2_Chess_Game.Strategy.MovementStrategy;

public abstract class Piece {
    protected boolean isWhite;
    protected MovementStrategy movementStrategy;
    protected boolean killed;

    public Piece(boolean isWhite, MovementStrategy movementStrategy) {
        this.isWhite = isWhite;
        this.movementStrategy = movementStrategy;
        this.killed = false;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public boolean canMove(Board board, Cell startCell, Cell endCell) {
        if (movementStrategy == null) {
            return false; // No movement strategy defined
        }
        return movementStrategy.canMove(board, startCell, endCell);
    }
}
