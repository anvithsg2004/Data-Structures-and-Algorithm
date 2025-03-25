package Top_150;

//🧪 Example:
//Input: " the sky is blue "
//Output: "blue is sky the"

//🧪 Dry Run:
//Input: " hello world! "
//After trim() → "hello world!"
//After split("\\s+") → ["hello", "world!"]
//Reverse and join → "world! hello"
//Output: "world! hello"

//1. s.trim()
//What it does: Removes leading and trailing spaces from the string s.
//Example:
//s = "   Hello World   ";
//s.trim() → "Hello World"

//2. .split("\\s+")
//What it does: Splits the trimmed string into an array of words, using one or more spaces as the separator.
//\\s+ explanation:
//\\s = regex for any whitespace (space, tab, etc.)
//+ = means one or more of the preceding (\s) character
//Together: \\s+ means one or more whitespace characters
//Why double backslashes \\s+?
//In Java, \ is an escape character, so \s becomes \\s in Java strings.
//So split("\\s+") means: "split by one or more whitespace characters"

//3. String[] words = ...
//This splits the string into an array of words.
//Example:
//s = "   Hello   World  ";
//s.trim() → "Hello   World"
//s.trim().split("\\s+") → ["Hello", "World"]

public class _9_Reverse_Words_in_a_String {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");  // Split by 1 or more spaces
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" ");
        }

        return sb.toString();
    }
}
