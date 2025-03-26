package DSA.Practice.Strings.Leetcode_Easy;

import java.util.HashMap;
import java.util.Map;

public class _15_Remove_Letter_To_Equalize_Frequency {

    //You are given a string word. Your task is to determine if removing
    //exactly one letter can make the frequency of all remaining letters equal.

    //Input 1:
    //word = "abcc"
    //Process:
    //Frequency: {a=1, b=1, c=2}
    //If we remove one c, we get {a=1, b=1, c=1}, which has equal frequencies.

    //Corrected Approach
    //Step 1: Count the frequency of each letter.
    //Step 2: Try removing each character once and check if remaining frequencies are equal.
    //Step 3: If we find any valid case, return true; otherwise, return false.

    public boolean equalFrequency(String word) {
        Map<Character, Integer> frequency = new HashMap<>();

        // Step 1: Count frequency of each letter
        for (char ch : word.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Try removing each letter once
        for (char ch : frequency.keySet()) {
            frequency.put(ch, frequency.get(ch) - 1);  // Simulate removal

            // Check if remaining frequencies are all equal
            if (areFrequenciesEqual(frequency)) {
                return true;
            }

            frequency.put(ch, frequency.get(ch) + 1);  // Undo removal
        }

        return false;
    }

    private boolean areFrequenciesEqual(Map<Character, Integer> freqMap) {
        int commonFreq = -1;

        for (int freq : freqMap.values()) {
            if (freq == 0) continue; // Skip removed characters

            if (commonFreq == -1) {
                commonFreq = freq;
            } else if (freq != commonFreq) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        _15_Remove_Letter_To_Equalize_Frequency obj = new _15_Remove_Letter_To_Equalize_Frequency();

        // Test cases
        System.out.println(obj.equalFrequency("abcc")); // true
        System.out.println(obj.equalFrequency("aabbcc")); // false
        System.out.println(obj.equalFrequency("aabb")); // true
        System.out.println(obj.equalFrequency("aaa")); // true
    }
}
