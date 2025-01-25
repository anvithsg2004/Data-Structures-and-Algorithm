package DSA.Practice.Binary_Search.Basic;

import java.util.PriorityQueue;

public class Sort_2D_to_1D_Array {

    public int[] sortMatrix(int[][] matrix) {

        int m = matrix.length; //Rows
        int n = matrix[0].length; //Columns

        int[] sortedArray = new int[n * m];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < m; i++) {

            minHeap.offer(new int[]{matrix[i][0], i, 0});

        }

        int index = 0;

        while (!minHeap.isEmpty()) {

            int[] current = minHeap.poll();

            sortedArray[index++] = current[0];

            int row = current[1];

            int column = current[2];

            if (column + 1 < n) {

                minHeap.offer(new int[]{matrix[row][column + 1], row, column + 1});

            }

        }

        return sortedArray;

    }

    public static void main(String[] args) {

    }
}
