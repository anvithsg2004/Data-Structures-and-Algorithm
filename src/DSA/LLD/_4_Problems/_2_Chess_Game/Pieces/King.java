package DSA.LLD._4_Problems._2_Chess_Game.Pieces;

import DSA.LLD._4_Problems._2_Chess_Game.Strategy.KingMovementStrategy;

public class King extends Piece {
    public King(boolean isWhite) {
        super(isWhite, new KingMovementStrategy());
    }
}
