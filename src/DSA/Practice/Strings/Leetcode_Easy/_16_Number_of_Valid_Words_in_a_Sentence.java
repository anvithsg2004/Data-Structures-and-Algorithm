package DSA.Practice.Strings.Leetcode_Easy;

import java.util.ArrayList;

//Problem Explanation
//You are given a sentence (a string of words separated by spaces). A word is valid if:
//It contains only lowercase letters, hyphens (-), or punctuation (!, ., ,).
//It has at most one hyphen (-), which should be between two lowercase letters.
//If it has punctuation, it should appear at the end of the word.
//Your task is to count the number of valid words in the sentence.

//Step 1: Split the sentence into words.
//Step 2: Validate each word using the following rules:
//It should not contain numbers.
//It can contain at most one hyphen (-), which must be between two letters.
//It can contain at most one punctuation mark (!, ., ,), which must be at the end.
//Step 3: Count and return the number of valid words.

//Input
//String sentence = "hello-world today-is great!";

//Step 1: Splitting the Sentence
//["hello-world", "today-is", "great!"]

//"cat and dog"	                ["cat", "and", "dog"]	                    3 ✅
//"!this 1-s b8d!"	            ["!this", "1-s", "b8d!"]	                0 ❌ (invalid words)
//"alice and-bob are playing."	["alice", "and-bob", "are", "playing."]	    3 ✅
//"hello-world today-is great!"	["hello-world", "today-is", "great!"]	    3 ✅

public class _16_Number_of_Valid_Words_in_a_Sentence {

    public int countValidWords(String sentence) {
        String[] words = sentence.trim().split("\\s+"); // Split by spaces

        int count = 0;
        for (String word : words) {
            if (isValid(word)) {
                count++;
            }
        }

        return count;
    }

    public boolean isValid(String word) {
        if (word.isEmpty()) return false;

        int hyphenCount = 0;
        int n = word.length();

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);

            // If the character is a number, return false
            if (Character.isDigit(ch)) {
                return false;
            }

            // If it's a hyphen, check its position
            if (ch == '-') {
                hyphenCount++;
                if (hyphenCount > 1) return false; // More than one hyphen is invalid
                if (i == 0 || i == n - 1 || !Character.isLetter(word.charAt(i - 1)) || !Character.isLetter(word.charAt(i + 1))) {
                    return false; // Hyphen must be between letters
                }
            }

            // If it's punctuation, it should be at the end
            if (ch == '!' || ch == '.' || ch == ',') {
                if (i != n - 1) return false; // Punctuation must be last character
            }
        }

        return true;
    }

    public static void main(String[] args) {
        _16_Number_of_Valid_Words_in_a_Sentence obj = new _16_Number_of_Valid_Words_in_a_Sentence();

        // Test cases
        System.out.println(obj.countValidWords("cat and  dog")); // 3
        System.out.println(obj.countValidWords("!this 1-s b8d!")); // 0
        System.out.println(obj.countValidWords("alice and-bob are playing.")); // 3
        System.out.println(obj.countValidWords("hello-world today-is great!")); // 4
    }
}
