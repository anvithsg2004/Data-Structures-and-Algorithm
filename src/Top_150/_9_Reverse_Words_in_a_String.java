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
