package DSA.Practice.Strings.Leetcode_Medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class _19_Custom_Sort_String {
    public static String customSortString(String order, String s) {

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), 0);
        }

        StringBuilder remaining = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (order.indexOf(s.charAt(i)) != -1) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            } else {
                remaining.append(s.charAt(i));
            }
        }

        StringBuilder result = new StringBuilder();

        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            Character c = m.getKey();
            Integer frequency = m.getValue();

            for (int i = 0; i < frequency; i++) {
                result.append(c);
            }

        }

        for (int i = 0; i < remaining.length(); i++) {
            result.append(remaining.charAt(i));
        }

        return result.toString();

    }

    public static void main(String[] args) {
        String order = "cba";
        String s = "abcd";
        System.out.println(customSortString(order, s));
    }
}
