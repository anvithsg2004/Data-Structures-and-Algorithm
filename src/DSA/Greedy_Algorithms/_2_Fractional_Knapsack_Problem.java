package DSA.Greedy_Algorithms;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

class itemComparator implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        double r1 = (double) (a.value) / (double) (a.weight);
        double r2 = (double) (b.value) / (double) (b.weight);
        if (r1 < r2) return 1;
        else if (r1 > r2) return -1;
        else return 0;
    }
}

public class _2_Fractional_Knapsack_Problem {
    public static double fractionalKnapsack(int W, Item[] arr, int n) {

        if (arr == null || arr.length == 0 || W == 0) {
            return 0.0;
        }

        //The sorting is in descending order.
        Arrays.sort(arr, new itemComparator());

        int currentWeight = 0;
        double finalValue = 0.0;

        for (int i = 0; i < n; i++) {
            if (currentWeight + arr[i].weight <= W) {
                currentWeight = currentWeight + arr[i].weight;
                finalValue = finalValue + arr[i].value;
            } else {
                int remain = W - currentWeight;
                finalValue = finalValue + ((double) arr[i].value / (double) arr[i].weight) * (double) remain;
                break;
            }
        }

        return finalValue;
    }
}
