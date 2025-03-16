package Top_150;

//💬 Problem: Word Pattern
//Given a pattern string and a sentence string s, determine if s follows the same pattern.
//Rules:
//Each character in pattern maps to a unique word in s.
//The mapping must be one-to-one (bijective).

//🧪 Example 1:
//pattern = "abba"
//s = "dog cat cat dog"
//Mapping:
//a → dog
//b → cat
//a → dog ✅
//b → cat ✅
//➡️ Valid → return true

//🧠 Intuition:
//Map each char in pattern to a word in s.
//Use 2 maps to ensure one-to-one:
//charToWord → map pattern char → word
//wordToChar → map word → pattern char

import java.util.HashMap;
import java.util.Map;

public class _16_Word_Pattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) return false;
            } else {
                charToWord.put(c, word);
            }

            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) return false;
            } else {
                wordToChar.put(word, c);
            }
        }
        return true;
    }
}
