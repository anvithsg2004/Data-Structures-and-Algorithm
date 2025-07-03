package DSA.LLD._4_Problems._2_Chess_Game.Pieces;

import DSA.LLD._4_Problems._2_Chess_Game.Strategy.KnightMovementStrategy;

public class Knight extends Piece {
    public Knight(boolean isWhite) {
        super(isWhite, new KnightMovementStrategy());
    }
}
