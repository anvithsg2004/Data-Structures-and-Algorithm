package DSA.Practice.Strings.Leetcode_Easy;

import java.util.HashMap;
import java.util.Map;

public class _15_Remove_Letter_To_Equalize_Frequency {

    public boolean equalFrequency(String word) {

        Map<Character, Integer> frequency = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            frequency.put(word.charAt(i), frequency.getOrDefault(word.charAt(i), 0) + 1);
        }

        Integer before = frequency.get(word.charAt(0));

        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            Integer value = entry.getValue();

            if (value != before) {
                return true;
            }

            Character ch = entry.getKey();
            before = entry.getValue();
        }

        return false;

    }

    public static void main(String[] args) {

    }
}
