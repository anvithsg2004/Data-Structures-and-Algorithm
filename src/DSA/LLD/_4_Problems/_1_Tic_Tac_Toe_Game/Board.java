package DSA.LLD._4_Problems._1_Tic_Tac_Toe_Game;

public class Board {
    private int rows;
    private int columns;
    private Symbol[][] grid;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new Symbol[rows][columns];
        // Initialize the board with EMPTY symbols
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = Symbol.EMPTY;
            }
        }
    }

    public boolean isValidMove(Position pos) {
        int row = pos.getRow();
        int col = pos.getCol();
        // Check if position is within bounds and empty
        return row >= 0 && row < rows && col >= 0 && col < columns && grid[row][col] == Symbol.EMPTY;
    }

    public void makeMove(Position pos, Symbol symbol) {
        grid[pos.getRow()][pos.getCol()] = symbol;
    }

    public boolean checkGameState(GameContext context) {
        // Check for a win
        if (isWinningLine(Symbol.X)) {
            context.setState(new XWonState());
            return true;
        } else if (isWinningLine(Symbol.O)) {
            context.setState(new OWonState());
            return true;
        }
        // Check for a draw (board is full)
        boolean isFull = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == Symbol.EMPTY) {
                    isFull = false;
                    break;
                }
            }
        }
        if (isFull) {
            context.setState(new DrawState());
            return true;
        }
        return false; // Game continues
    }

    public boolean isWinningLine(Symbol symbol) {
        // Check rows
        for (int i = 0; i < rows; i++) {
            boolean win = true;
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        // Check columns
        for (int j = 0; j < columns; j++) {
            boolean win = true;
            for (int i = 0; i < rows; i++) {
                if (grid[i][j] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        // Check main diagonal
        boolean win = true;
        for (int i = 0; i < rows; i++) {
            if (grid[i][i] != symbol) {
                win = false;
                break;
            }
        }
        if (win) return true;
        // Check other diagonal
        win = true;
        for (int i = 0; i < rows; i++) {
            if (grid[i][rows - 1 - i] != symbol) {
                win = false;
                break;
            }
        }
        return win;
    }

    // For display purposes
    public void displayBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
