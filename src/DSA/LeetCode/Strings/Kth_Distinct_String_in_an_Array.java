package DSA.LeetCode.Strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Kth_Distinct_String_in_an_Array {

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() > 1) {
                iterator.remove();
            }
        }

        String found = "";
        int currentIndex = 0;

        for (String c : arr) {
            if (map.containsKey(c) && map.get(c) == 1) {
                if (currentIndex == k - 1) {
                    found = c;
                    break;
                }
                currentIndex++;
            }
        }

        return found;
    }

    public static void main(String[] args) {

    }
}
