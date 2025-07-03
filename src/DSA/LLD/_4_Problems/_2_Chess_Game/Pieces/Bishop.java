package DSA.LLD._4_Problems._2_Chess_Game.Pieces;

import DSA.LLD._4_Problems._2_Chess_Game.Strategy.BishopMovementStrategy;

public class Bishop extends Piece {
    public Bishop(boolean isWhite) {
        super(isWhite, new BishopMovementStrategy());
    }
}