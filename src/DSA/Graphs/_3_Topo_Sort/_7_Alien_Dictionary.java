package DSA.Graphs._3_Topo_Sort;

import java.util.*;

public class _7_Alien_Dictionary {
    public String alienOrder(String[] words) {

        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            // Edge Case
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {

                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (c1 != c2) {

                    if (!adj.get(c1).contains(c2)) {
                        adj.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }

                    break;

                }

            }

        }

        // Kahn's Algo
        Queue<Character> queue = new LinkedList<>();

        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.add(c);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {

            char c = queue.poll();
            result.append(c);

            for (char neighbour : adj.get(c)) {

                inDegree.put(neighbour, inDegree.get(neighbour) - 1);

                if (inDegree.get(neighbour) == 0) {
                    queue.add(neighbour);
                }

            }

        }

        if (result.length() != inDegree.size()) {
            return "";
        }

        return result.toString();

    }
}
