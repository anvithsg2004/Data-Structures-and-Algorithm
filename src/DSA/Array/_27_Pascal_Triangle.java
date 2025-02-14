package DSA.Array;

import java.util.ArrayList;
import java.util.List;

public class _27_Pascal_Triangle {
    //There are three variations.

    //Variation 1
    //we are given the row number r and the column number c,
    //and we need to find out the element at position (r,c).
    //This means in the rth row and cth column what is the value.
    //Find r-1 C c-1
    public static long nCr(int n, int r) {

        //Remember this (10 * 9 * 8)/(1 * 2 * 3)

        long res = 1;

        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }

        return res;
    }

    //Variation 2
    //Given the row number n. Print the n-th row of Pascal’s triangle.
    public static void pascalTriangle(int n) {
        // printing the entire row n:
        for (int c = 1; c <= n; c++) {
            System.out.print(nCr(n - 1, c - 1) + " ");
        }
        System.out.println();
    }

    //Variation 3
    //Final Code
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i <= numRows; i++) {

            result.add(generateRow(i));

        }

        return result;

    }

    public static List<Integer> generateRow(int row) {

        long ans = 1;

        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);

        for (int col = 1; col < row; col++) {

            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int) ans);

        }

        return ansRow;
    }
}
