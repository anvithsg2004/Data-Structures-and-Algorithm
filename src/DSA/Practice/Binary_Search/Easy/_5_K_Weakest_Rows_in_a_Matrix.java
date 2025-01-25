package DSA.Practice.Binary_Search.Easy;

import java.util.PriorityQueue;

public class _5_K_Weakest_Rows_in_a_Matrix {

    public int[] kWeakestRows(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;

        PriorityQueue<int[]> res = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
        );

        for (int i = 0; i < row; i++) {

            int last = 0;

            for (int j = 0; j < col; j++) {

                if (mat[i][j] == 1) {
                    last++;
                } else {
                    break;
                }

            }

            res.add(new int[]{last, i});

        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {

            ans[i] = res.poll()[1];

        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
