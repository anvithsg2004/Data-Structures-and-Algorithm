package Top_150;

//💬 Problem: Group Anagrams
//Given an array of strings strs, group the anagrams together.
//🧩 Anagram Definition:
//An anagram is formed by rearranging the letters of another word.
//🧪 Example:
//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output:
//[
//  ["eat","tea","ate"],
//  ["tan","nat"],
//  ["bat"]
//]

//🧠 Intuition:
//Anagrams have the same letters when sorted.
//Use a HashMap:
//Key: sorted word
//Value: list of anagrams with that sorted key

import java.util.*;

public class _17_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
