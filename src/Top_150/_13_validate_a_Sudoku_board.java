package Top_150;

//🧩 Problem Recap:
//You have a 9x9 Sudoku board, filled with characters '1' to '9' and '.' (empty cells).
//You need to check if it's valid:
//Rows → No repeated numbers.
//Columns → No repeated numbers.
//3x3 Boxes → No repeated numbers.
//You don’t need to solve it — just check if the current filled-in numbers are valid!

//🔧 Strategy:
//We’ll use 3 hash sets to track seen numbers:
//One for each row.
//One for each column.
//One for each 3x3 box.

import java.util.HashSet;

public class _13_validate_a_Sudoku_board {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    String rowKey = num + " in row " + i;
                    String colKey = num + " in col " + j;
                    String boxKey = num + " in box " + (i / 3) + "-" + (j / 3);

                    if (seen.contains(rowKey) || seen.contains(colKey) || seen.contains(boxKey)) {
                        return false; // Duplicate found
                    }

                    seen.add(rowKey);
                    seen.add(colKey);
                    seen.add(boxKey);
                }
            }
        }

        return true; // No duplicates found
    }
}
