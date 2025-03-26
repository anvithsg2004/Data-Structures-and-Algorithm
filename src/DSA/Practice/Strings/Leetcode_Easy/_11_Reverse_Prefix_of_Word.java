package DSA.Practice.Strings.Leetcode_Easy;

public class _11_Reverse_Prefix_of_Word {

    //You are given a string word and a character ch.
    //You need to reverse the prefix of word up to and including the first occurrence of ch.
    //If ch is not found, return the original word.

    //Input:
    //word = "abcdefd", ch = 'd'

    //Process:
    //The first occurrence of 'd' is at index 3
    //Reverse the prefix "abcd" → "dcba"
    //Append the rest "efd" → Output: "dcbaefd"
    //Output:
    //"dcbaefd"

    //Input:
    //word = "xyxzxe", ch = 'z'
    //Process:
    //The first 'z' is at index 3
    //Reverse "xyxz" → "zxyx"
    //Append "xe" → Output: "zxyxxe"
    //Output:
    //"zxyxxe"

    public String reversePrefix(String word, char ch) {

        int index = word.indexOf(ch); // Find first occurrence of 'ch'

        if (index == -1) return word; // If 'ch' is not found, return original word

        StringBuilder sb = new StringBuilder(word.substring(0, index + 1));
        sb.reverse(); // Reverse only the prefix part

        return sb.append(word.substring(index + 1)).toString(); // Append the rest of the word
    }

    public static void main(String[] args) {
        _11_Reverse_Prefix_of_Word obj = new _11_Reverse_Prefix_of_Word();
        System.out.println(obj.reversePrefix("abcdefd", 'd')); // Output: "dcbaefd"
        System.out.println(obj.reversePrefix("xyxzxe", 'z'));  // Output: "zxyxxe"
        System.out.println(obj.reversePrefix("abcd", 'z'));    // Output: "abcd" (no change)
    }
}
