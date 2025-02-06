package DSA.Practice.Graphs.Easy;

import java.util.LinkedList;
import java.util.Queue;

class Position {

    int row;
    int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

}

public class _4_Find_The_Perimeter {

    public final int[] drow = {-1, 0, 1, 0};
    public final int[] dcol = {0, 1, 0, -1};

    public int findPerimeter(int[][] matrix) {

        int n = matrix.length;

        Queue<Position> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    queue.add(new Position(i, j));
                }
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {

            Position position = queue.peek();
            int row = position.row;
            int col = position.col;
            queue.remove();


            count = count + noOfOnes(row, col, matrix);

        }

        return count;
    }

    public int noOfOnes(int row, int col, int[][] matrix) {

        int n = matrix.length;

        int count = 0;

        for (int i = 0; i < 4; i++) {
            int newRow = row + drow[i];
            int newCol = col + dcol[i];

            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n || matrix[newRow][newCol] == 0) {
                count++;
            }
        }

        return count;

    }
}
