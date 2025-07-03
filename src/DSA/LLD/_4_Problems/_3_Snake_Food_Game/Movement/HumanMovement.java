package DSA.LLD._4_Problems._3_Snake_Food_Game.Movement;

import DSA.LLD._4_Problems._3_Snake_Food_Game.Pair;

public class HumanMovement implements Movement {
    @Override
    public Pair getNextPosition(Pair currentHead, String direction) {
        int row = currentHead.getRow();
        int col = currentHead.getCol();

        switch (direction) {
            case "U":
                return new Pair(row - 1, col);
            case "D":
                return new Pair(row + 1, col);
            case "L":
                return new Pair(row, col - 1);
            case "R":
                return new Pair(row, col + 1);
            default:
                return currentHead;
        }

    }
}
