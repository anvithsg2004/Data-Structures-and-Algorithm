package DSA.Practice.Strings.Leetcode_Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _14_Word_Subsets {
    //Best Code.
    public List<String> wordSubsets2(String[] words1, String[] words2) {
        int freq[] = new int[26];
        for (String word : words2) { //M
            int temp[] = getFreq(word); //p
            for (int i = 0; i < 26; i++) { //26
                freq[i] = Math.max(freq[i], temp[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for (String word : words1) { //n
            int temp[] = getFreq(word); //p
            boolean flag = true;
            for (int i = 0; i < 26; i++) { //26
                if (freq[i] > temp[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(word);
            }
        }
        return res;
    }

    public int[] getFreq(String word) {
        int freq[] = new int[26];
        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }
        return freq;
    }

    //My Shit Code;
    public List<String> wordSubsets(String[] words1, String[] words2) {

        ArrayList<HashMap<Character, Integer>> word1Strings = new ArrayList<>();
        ArrayList<HashMap<Character, Integer>> word2Strings = new ArrayList<>();

        // Count frequencies for words1
        if (words1 != null) {
            for (int i = 0; i < words1.length; i++) {
                HashMap<Character, Integer> charFrequency = new HashMap<>();
                for (int j = 0; j < words1[i].length(); j++) {
                    char c = words1[i].charAt(j);
                    charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
                }
                word1Strings.add(charFrequency);
            }
        }

        // Count frequencies for words2
        if (words2 != null) {
            for (int i = 0; i < words2.length; i++) {
                HashMap<Character, Integer> charFrequency = new HashMap<>();
                for (int j = 0; j < words2[i].length(); j++) {
                    char c = words2[i].charAt(j);
                    charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
                }
                word2Strings.add(charFrequency);
            }
        }

        // Calculate maximum character frequencies required for words2
        HashMap<Character, Integer> maxFrequency = new HashMap<>();
        for (HashMap<Character, Integer> freqMap : word2Strings) {
            for (Character c : freqMap.keySet()) {
                maxFrequency.put(c, Math.max(maxFrequency.getOrDefault(c, 0), freqMap.get(c)));
            }
        }

        // Print frequencies for words1
        System.out.println("Character Frequencies for words1:");
        for (int i = 0; i < word1Strings.size(); i++) {
            System.out.println("Word: " + words1[i] + ", Frequencies: " + word1Strings.get(i));
        }

        // Print frequencies for words2
        System.out.println("Character Frequencies for words2:");
        for (int i = 0; i < word2Strings.size(); i++) {
            System.out.println("Word: " + words2[i] + ", Frequencies: " + word2Strings.get(i));
        }

        // Print maximum character frequencies required for words2
        System.out.println("Maximum Frequencies required for words2:");
        System.out.println(maxFrequency);

        // Find universal words in words1
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < word1Strings.size(); i++) {
            boolean isUniversal = true;
            HashMap<Character, Integer> word1Freq = word1Strings.get(i);

            for (Character c : maxFrequency.keySet()) {
                if (word1Freq.getOrDefault(c, 0) < maxFrequency.get(c)) {
                    isUniversal = false;
                    break;
                }
            }

            if (isUniversal) {
                result.add(words1[i]);
            }
        }

        // Print universal words
        System.out.println("Universal Words:");
        System.out.println(result);

        return result;
    }
}
