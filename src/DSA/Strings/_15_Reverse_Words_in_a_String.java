package DSA.Strings;

import java.util.ArrayList;

public class _15_Reverse_Words_in_a_String {
    public String reverseWords(String s) {
        String[] words = s.split(" ");

        ArrayList<String> result = new ArrayList<>();

        // Iterate over the split words and trim them
        for (String word : words) {
            String trimmedWord = word.trim();
            if (!trimmedWord.isEmpty()) {
                result.add(trimmedWord); // Add non-empty trimmed words to the list
            }
        }

        // Reverse the list of words
        ArrayList<String> reversedResult = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            reversedResult.add(result.get(i)); // Add words to the new list in reverse order
        }

        // Join the reversed words into a single string
        StringBuilder reversedSentence = new StringBuilder();
        for (String word : reversedResult) {
            reversedSentence.append(word).append(" "); // Append words with a space
        }

        // Trim the final result to remove any extra space at the end

        return reversedSentence.toString().trim();
    }
}
