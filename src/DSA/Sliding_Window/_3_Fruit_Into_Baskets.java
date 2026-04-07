package DSA.Sliding_Window;

import java.util.*;

public class _3_Fruit_Into_Baskets {

    public int totalFruit(int[] fruits) {

        int n = fruits.length;

        int i = 0;
        int j = 0;

        int maxLen = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while (j < n) {

            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[i], map.get(fruits[i]) - 1);

                if (map.get(fruits[i]) == 0) {
                    map.remove(fruits[i]);
                }

                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;

        }

        return maxLen;

    }
}
