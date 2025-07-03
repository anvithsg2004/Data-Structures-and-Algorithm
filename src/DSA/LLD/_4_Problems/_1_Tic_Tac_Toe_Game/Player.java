package DSA.LLD._4_Problems._1_Tic_Tac_Toe_Game;

public class Player {
    private Symbol symbol;
    private PlayerStrategy strategy;

    public Player(Symbol symbol, PlayerStrategy strategy) {
        this.symbol = symbol;
        this.strategy = strategy;
    }

    public Position makeMove(Board board) {
        return strategy.makeMove(board);
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
