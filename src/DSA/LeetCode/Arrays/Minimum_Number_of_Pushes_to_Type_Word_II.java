package DSA.LeetCode.Arrays;

import java.util.Arrays;

public class Minimum_Number_of_Pushes_to_Type_Word_II {

    public int minimumPushes(String word) {
        int[] arr = new int[26]; // Corrected array length to 26
        for (char ch : word.toCharArray()) {
            arr[ch - 'a']++;
        }

        Arrays.sort(arr);
        int count = 0;
        int minKeys = 0; // Corrected variable name from minKyes to minKeys

        for (int i = 25; i >= 0; i--) {
            int mul = 0;
            if (count < 8) {
                mul = 1;
            } else if (count < 16) {
                mul = 2;
            } else if (count < 24) {
                mul = 3;
            } else {
                mul = 4;
            }
            int val = arr[i] * mul;
            minKeys += val; // Corrected variable name from minKyes to minKeys
            count++;
        }

        return minKeys;
    }

    public static void main(String[] args) {

    }
}
