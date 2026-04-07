package DSA.Greedy_Algorithms;

import java.util.*;

class Item {
    int value;
    int weight;

    public Item(int v, int w) {
        this.value = v;
        this.weight = w;
    }
}

public class _2_Fractional_Knapsack_Problem {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {

        int n = val.length;

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(val[i], wt[i]);
        }

        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        double totalValue = 0.0;

        for (Item item : items) {

            if (capacity >= item.weight) {
                totalValue = totalValue + item.value;
                capacity = capacity - item.weight;
            } else {
                totalValue = totalValue + item.value * ((double) capacity / item.weight);
                break;
            }

        }

        return totalValue;

    }
}
