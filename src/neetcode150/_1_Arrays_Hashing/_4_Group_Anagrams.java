package neetcode150._1_Arrays_Hashing;

import java.util.*;

public class _4_Group_Anagrams {

    // My Method
    public List<List<String>> groupAnagrams(String[] strs) {

        int n = strs.length;

        List<List<String>> results = new ArrayList<>();

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && i != j && isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    visited[j] = true;
                }
            }

            results.add(group);
        }

        return results;

    }

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] fre = new int[26];

        // Increase
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            fre[index]++;
        }

        // Decrease
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            fre[index]--;
        }

        // Check for Zeros
        for (int i = 0; i < 26; i++) {
            if (fre[i] != 0) {
                return false;
            }
        }

        return true;

    }

    // Sort the word and use it as key
    public List<List<String>> groupAnagrams1(String[] strs) {

        int n = strs.length;

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);

        }

        return new ArrayList<>(map.values());

    }

    // Calculate the fre -> Build a String from that -> Use it as Key
    public List<List<String>> groupAnagrams2(String[] strs) {

        int n = strs.length;

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            int[] fre = new int[26];

            for (char c : str.toCharArray()) {
                fre[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for (int count : fre) {
                key.append(count).append('#');
            }

            map.putIfAbsent(key.toString(), new ArrayList<>());
            map.get(key.toString()).add(str);

        }

        return new ArrayList<>(map.values());

    }

}
