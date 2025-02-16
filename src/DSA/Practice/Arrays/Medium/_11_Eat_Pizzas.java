package DSA.Practice.Arrays.Medium;

import java.util.Arrays;

public class _11_Eat_Pizzas {
    public long maxWeight(int[] pizzas) {
        int n = pizzas.length;
        Arrays.sort(pizzas); // Sort the array first
        long maxWeight = 0;

        // We process groups of 4 from the back
        for (int i = 0; i < n / 4; i++) {
            int groupStart = n - (i + 1) * 4; // Last groups come first
            int W = pizzas[groupStart];       // Smallest
            int X = pizzas[groupStart + 1];
            int Y = pizzas[groupStart + 2];   // 2nd Largest
            int Z = pizzas[groupStart + 3];   // Largest

            if (i % 2 == 0) {
                maxWeight += Z;  // Odd Day -> Take Z
            } else {
                maxWeight += Y;  // Even Day -> Take Y
            }
        }

        return maxWeight;
    }
}
