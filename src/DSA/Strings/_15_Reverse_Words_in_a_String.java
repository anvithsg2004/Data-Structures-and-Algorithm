package DSA.Strings;

import java.util.ArrayList;

//Dry Run of reverseWords(" hello world ")
//Step 1: Splitting the String
//words = ["", "", "hello", "", "", "world", "", ""]
//Extra spaces create empty strings in the array.
//Step 2: Removing Empty Strings
//result = ["hello", "world"]
//We keep only non-empty trimmed words.
//Step 3: Reversing the Words
//reversedResult = ["world", "hello"]
//Step 4: Joining the Words
//Intermediate string: "world hello "
//Final result after trimming: "world hello"

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
