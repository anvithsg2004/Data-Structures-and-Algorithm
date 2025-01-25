package DSA.Practice.Strings.Leetcode_Medium;

import java.util.HashMap;
import java.util.Map;

public class _10_Optimal_Partition_of_String {

    public int partitionString(String s) {

        Map<Character, Integer> frequency = new HashMap<>();

        int miniCount = 0;

        for (int end = 0; end < s.length(); end++) {

            char charAtEnd = s.charAt(end);

            frequency.put(charAtEnd, frequency.getOrDefault(charAtEnd, 0) + 1);

            if (frequency.get(charAtEnd) > 1) {

                miniCount++;

                frequency.clear();

                frequency.put(charAtEnd, 1);

            }

        }

        if (!frequency.isEmpty()) {

            miniCount++;

        }

        return miniCount;

    }

    public static void main(String[] args) {

    }
}
