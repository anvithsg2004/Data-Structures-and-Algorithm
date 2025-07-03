package DSA.LLD._4_Problems._2_Chess_Game.Game;

import DSA.LLD._4_Problems._2_Chess_Game.Board.Board;
import DSA.LLD._4_Problems._2_Chess_Game.Board.Cell;
import DSA.LLD._4_Problems._2_Chess_Game.Board.Move;
import DSA.LLD._4_Problems._2_Chess_Game.BoardGames;
import DSA.LLD._4_Problems._2_Chess_Game.Pieces.Piece;

public class Game implements BoardGames {
    private Board board;
    private Player player1;
    private Player player2;
    private State status;

    public Game(Player player1, Player player2) {
        this.board = Board.getInstance();
        this.player1 = player1;
        this.player2 = player2;
        this.status = status.ACTIVE;
    }

    public void makeMove(Move move) {
        Cell startCell = move.getStartCell();
        Cell endCell = move.getEndCell();
        Piece piece = startCell.getPiece();

        if (piece != null && piece.canMove(board, startCell, endCell)) {
            if (endCell.getPiece() != null) {
                endCell.getPiece().setKilled(true);
            }
            endCell.setPiece(piece);
            startCell.setPiece(null);
            // Update game status if needed (e.g., check for checkmate, stalemate)
        }
    }

    public State getStatus() {
        return status;
    }
}
