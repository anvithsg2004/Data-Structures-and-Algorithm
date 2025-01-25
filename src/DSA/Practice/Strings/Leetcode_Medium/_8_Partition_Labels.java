package DSA.Practice.Strings.Leetcode_Medium;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class _8_Partition_Labels {

    public List<Integer> partitionLabels(String s) {

        Map<Character, Integer> lastSeen = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i ++) {

            lastSeen.put(s.charAt(i), i);

        }

        List<Integer> result = new ArrayList<>();

        int partitionStart = 0;
        int partitionEnd = 0;

        for (int i = 0; i < s.length(); i++) {

            partitionEnd = Math.max(partitionEnd, lastSeen.get(s.charAt(i)));

            if (i == partitionEnd) {

                result.add(partitionEnd - partitionStart + 1);

                partitionStart = partitionEnd + 1;

            }

        }

        return result;
    }

    public static void main(String[] args) {

    }
}
