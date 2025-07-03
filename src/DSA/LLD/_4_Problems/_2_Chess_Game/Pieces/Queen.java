package DSA.LLD._4_Problems._2_Chess_Game.Pieces;

import DSA.LLD._4_Problems._2_Chess_Game.Strategy.QueenMovementStrategy;

public class Queen extends Piece {
    public Queen(boolean isWhite) {
        super(isWhite, new QueenMovementStrategy());
    }
}