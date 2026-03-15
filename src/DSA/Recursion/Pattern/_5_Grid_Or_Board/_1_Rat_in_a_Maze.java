package DSA.Recursion.Pattern._5_Grid_Or_Board;

import java.util.*;

public class _1_Rat_in_a_Maze {
    public ArrayList<String> ratInMaze(int[][] maze) {

        int row = maze.length;
        int col = maze[0].length;

        String[] directions = {"U", "D", "L", "R"};
        int[] rowDir = {-1, 1, 0, 0};
        int[] colDir = {0, 0, -1, 1};

        boolean[][] visited = new boolean[row][col];

        visited[0][0] = true;

        ArrayList<String> result = new ArrayList<>();

        if (maze[0][0] == 0) return result;

        helper(0, 0, result, new StringBuilder(), maze, visited, directions, rowDir, colDir);

        Collections.sort(result);

        return result;

    }

    public void helper(int row, int col, ArrayList<String> result, StringBuilder temp, int[][] maze, boolean[][] visited, String[] directions, int[] rowDir, int[] colDir) {

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            result.add(temp.toString());
            return;
        }

        if (row >= maze.length || col >= maze[0].length) {
            return;
        }

        for (int i = 0; i < 4; i++) {

            int newRow = row + rowDir[i];
            int newCol = col + colDir[i];

            if (newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length && !visited[newRow][newCol] && maze[newRow][newCol] == 1) {

                // Choose
                visited[newRow][newCol] = true;
                temp.append(directions[i]);

                // Explore
                helper(newRow, newCol, result, temp, maze, visited, directions, rowDir, colDir);

                // Undo
                visited[newRow][newCol] = false;
                temp.deleteCharAt(temp.length() - 1);

            }

        }

    }
}
