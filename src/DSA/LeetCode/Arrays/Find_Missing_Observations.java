package DSA.LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Find_Missing_Observations {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] result = new int[n];
        int m = rolls.length;
        ArrayList<Integer> arrayList = new ArrayList<>(n);

        int sum = Arrays.stream(rolls).sum();
        int totalSum = mean * (m + n);
        int sumMissing = totalSum - sum;

        if (sumMissing < n || sumMissing > 6 * n) {
            return new int[0];
        }

        int x2 = sumMissing / n;
        int x1 = sumMissing % n;

        // Add x2 to all positions
        for (int i = 0; i < n; i++) {
            arrayList.add(x2);
        }

        // Distribute the remainder (x1) across the first x1 positions
        for (int i = 0; i < x1; i++) {
            arrayList.set(i, arrayList.get(i) + 1);
        }

        // Transfer from arrayList to result
        for (int i = 0; i < n; i++) {
            result[i] = arrayList.get(i);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
