package DSA.Strings;

import java.util.HashMap;
import java.util.Map;

public class _24_Count_number_of_substrings {
    public static long substrCount(String s, int k) {

        return help(s, k) - help(s, k - 1);

    }

    public static long help(String s, int k) {

        int right;
        int left = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();


        for (right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);

            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while (map.size() > k) {

                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;

            }

            count = count + (right - left + 1);

        }

        return count;

    }
}
