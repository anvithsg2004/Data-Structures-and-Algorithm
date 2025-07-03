package DSA.LLD._4_Problems._1_Tic_Tac_Toe_Game;

public class DrawState implements GameState {
    @Override
    public boolean isGameOver() {
        return true; // Game ended in a draw
    }
}
