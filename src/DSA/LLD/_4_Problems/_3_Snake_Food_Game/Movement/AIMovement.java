package DSA.LLD._4_Problems._3_Snake_Food_Game.Movement;

import DSA.LLD._4_Problems._3_Snake_Food_Game.Pair;

public class AIMovement implements Movement {
    @Override
    public Pair getNextPosition(Pair currentHead, String direction) {
        return currentHead;
    }
}
