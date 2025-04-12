package DSA;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class practice {
    public String frequencySort(String s) {

        Map<Character, Integer> frequencies = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            frequencies.put(s.charAt(i), frequencies.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );

        pq.addAll(frequencies.entrySet());

        StringBuilder answer = new StringBuilder();

        while (!pq.isEmpty()) {

            Map.Entry<Character, Integer> map = pq.poll();

            Character character = map.getKey();
            Integer frequency = map.getValue();

            for (int i = 0; i < frequency; i++) {
                answer.append(character);
            }


        }

        return answer.toString();

    }
}
