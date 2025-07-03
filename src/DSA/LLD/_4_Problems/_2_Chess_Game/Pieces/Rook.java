package DSA.LLD._4_Problems._2_Chess_Game.Pieces;

import DSA.LLD._4_Problems._2_Chess_Game.Strategy.RookMovementStrategy;

public class Rook extends Piece {
    public Rook(boolean isWhite) {
        super(isWhite, new RookMovementStrategy());
    }
}
