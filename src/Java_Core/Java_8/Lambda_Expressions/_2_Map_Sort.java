package Java_Core.Java_8.Lambda_Expressions;

import java.util.*;

public class _2_Map_Sort {
    public static void main(String[] args) {
        // Create a sample map
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Orange", 5);
        map.put("Banana", 20);
        map.put("Grapes", 15);

        // Create a list from the map's keys
        List<String> sortedKeys = new ArrayList<>(map.keySet());

        // Sort the list of keys using a lambda expression
        Collections.sort(sortedKeys, (key1, key2) -> key1.compareTo(key2)); // or simply: Collections.sort(sortedKeys)

        // Sort the list of keys in descending order using a lambda expression
        Collections.sort(sortedKeys, (key1, key2) -> key2.compareTo(key1));  // Sorting in reverse order

        // Create a LinkedHashMap to maintain the order of the sorted keys
        Map<String, Integer> sortedMap = new LinkedHashMap<>();

        // Populate the sortedMap with sorted keys and corresponding values
        for (String key : sortedKeys) {
            sortedMap.put(key, map.get(key));
        }

        // Print the sorted map
        sortedMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
