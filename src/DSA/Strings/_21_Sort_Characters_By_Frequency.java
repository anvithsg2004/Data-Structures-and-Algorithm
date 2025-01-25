package DSA.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _21_Sort_Characters_By_Frequency {

    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c , 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        pq.addAll(map.entrySet());

        StringBuilder answer = new StringBuilder();

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            answer.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }

        return answer.toString();

    }

    public static void main(String[] args) {

    }
}
