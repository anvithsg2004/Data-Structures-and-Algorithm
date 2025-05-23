package DSA.Dynamic_Programming._2_1D_Array_DP;

import java.util.ArrayList;

//Here the houses will be in the circular order.
public class _5_House_Robber_2 {
    public static long robStreet(int n, ArrayList<Integer> arr) {

        //We cannot rob two adjacent houses.
        //Since the houses are arranged in a circle, the first and last houses are adjacent.
        //We have to choose either the first house or the last house, but not both.

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        if (n == 1) {
            return arr.get(0);
        }

        for (int i = 0; i < n; i++) {

            if (i != 0) arr1.add(arr.get(i));
            if (i != n - 1) arr2.add(arr.get(i));
        }

        long ans1 = solve(arr1);
        long ans2 = solve(arr2);

        return Math.max(ans1, ans2);
    }

    static long solve(ArrayList<Integer> arr) {
        int n = arr.size();
        long prev = arr.get(0);
        long prev2 = 0;

        for (int i = 1; i < n; i++) {
            long pick = arr.get(i);
            if (i > 1)
                pick += prev2;
            long nonPick = 0 + prev;

            long cur_i = Math.max(pick, nonPick);
            prev2 = prev;
            prev = cur_i;

        }
        return prev;
    }
}
