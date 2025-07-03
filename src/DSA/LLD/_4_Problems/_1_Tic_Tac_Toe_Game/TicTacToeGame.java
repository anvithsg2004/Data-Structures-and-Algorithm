package DSA.LLD._4_Problems._1_Tic_Tac_Toe_Game;

public class TicTacToeGame {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private GameContext gameContext;

    public TicTacToeGame(PlayerStrategy xStrategy, PlayerStrategy oStrategy, int rows, int columns) {
        this.board = new Board(rows, columns);
        this.playerX = new Player(Symbol.X, xStrategy);
        this.playerO = new Player(Symbol.O, oStrategy);
        this.currentPlayer = playerX; // X starts
        this.gameContext = new GameContext();
    }

    public void play() {
        System.out.println("Tic Tac Toe Game Started!");
        while (!gameContext.isGameOver()) {
            // Display the board
            board.displayBoard();
            // Current player makes a move
            Position pos = currentPlayer.makeMove(board);
            board.makeMove(pos, currentPlayer.getSymbol());
            // Check game state
            board.checkGameState(gameContext);
            // Switch player
            switchPlayer();
        }
        // Display final board and announce result
        board.displayBoard();
        announceResult();
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    public void announceResult() {
        GameState state = gameContext.getState();
        if (state instanceof XWonState) {
            System.out.println("Player X wins!");
        } else if (state instanceof OWonState) {
            System.out.println("Player O wins!");
        } else if (state instanceof DrawState) {
            System.out.println("It's a draw!");
        }
    }

    // Main method to run the game
    public static void main(String[] args) {
        PlayerStrategy xStrategy = new HumanPlayerStrategy("Player X");
        PlayerStrategy oStrategy = new HumanPlayerStrategy("Player O");
        TicTacToeGame game = new TicTacToeGame(xStrategy, oStrategy, 3, 3);
        game.play();
    }
}
