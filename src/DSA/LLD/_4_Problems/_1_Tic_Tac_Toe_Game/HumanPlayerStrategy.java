package DSA.LLD._4_Problems._1_Tic_Tac_Toe_Game;

import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy {
    private Scanner scanner;
    private String playerName;

    public HumanPlayerStrategy(String playerName) {
        this.playerName = playerName;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Position makeMove(Board board) {
        System.out.println(playerName + "'s turn. Enter row (0-2) and column (0-2): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        Position pos = new Position(row, col);

        // Keep asking for input until a valid move is made
        while (!board.isValidMove(pos)) {
            System.out.println("Invalid move! Try again. Enter row (0-2) and column (0-2): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            pos = new Position(row, col);
        }
        return pos;
    }
}
