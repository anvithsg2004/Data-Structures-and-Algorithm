package DSA.Graphs._2_Problems_on_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    //This will store which has turned to rotten tomatoes(which means 2)
    int row;
    int column;
    //Time taken to get rotten
    int time;

    public Pair(int row, int column, int time) {
        this.row = row;
        this.column = column;
        this.time = time;
    }
}

public class _2_Rotting_Oranges {

    public int orangesRotting(int[][] grid) {

        //Rows and Columns
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();

        int[][] visited = new int[n][m];

        //To count how many fresh tomatoes were there.
        //At last, we checked whether countFresh are equal to rotten tomatoes.
        //If same then return the minimum time or else return -1.
        int countFresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                //If any rotten tomatoes are there, put it in the queue and
                //make the time as 0 because in 0th time it has become rotten.
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                    //Mark in the visited matrix as rotten(2) and let rest be as 0.
                    visited[i][j] = 2;
                } else {
                    visited[i][j] = 0;
                }

                //At last, we check whether countFresh are equal to rotten tomatoes.
                //If same then return the minimum time or else return -1.
                if (grid[i][j] == 1) {
                    countFresh = countFresh + 1;
                }

            }
        }

        int maximumTime = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        //To count how many are converted to rotten tomatoes.
        int count = 0;

        while (!queue.isEmpty()) {
            int r = queue.peek().row;
            int c = queue.peek().column;
            int time = queue.peek().time;
            //This is to get the maximum time to make all fresh to rotten tomato's.
            maximumTime = Math.max(maximumTime, time);
            queue.remove();
            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                //Condition :-
                //1) nrow should be greater than zero and lesser than n, which means this is not out of the matrix.
                //2) ncol should be greater than zero and lesser than m, which means this is not out of the matrix.
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    //If it is present, then add the index of the matrix to the queue and increase the time.
                    queue.add(new Pair(nrow, ncol, time + 1));
                    //Make the visited as 2.
                    visited[nrow][ncol] = 2;
                    //Increase the number of fresh converted to rotten tomato's.
                    count++;
                }
            }
        }

        if (count != countFresh) {
            return -1;
        }

        return maximumTime;
    }
}
