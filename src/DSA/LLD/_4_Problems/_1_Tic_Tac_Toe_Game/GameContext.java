package DSA.LLD._4_Problems._1_Tic_Tac_Toe_Game;

public class GameContext {
    private GameState state;

    public GameContext() {
        this.state = new InProgressState(); // Default state
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public boolean isGameOver() {
        return state.isGameOver();
    }

    public GameState getState() {
        return state;
    }
}
