package DSA.LLD._4_Problems._1_Tic_Tac_Toe_Game;

public class OWonState implements GameState {
    @Override
    public boolean isGameOver() {
        return true; // Game ended with O winning
    }
}
