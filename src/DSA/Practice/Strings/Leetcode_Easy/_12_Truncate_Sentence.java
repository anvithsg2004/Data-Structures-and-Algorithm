package DSA.Practice.Strings.Leetcode_Easy;

//You are given a sentence s (a string of words separated by spaces) and an integer k.
//Your task is to truncate the sentence after the first k words and return the result.

//Input:
//s = "Hello how are you Contestant", k = 4
//Process:
//The first 4 words: "Hello how are you"
//The remaining words "Contestant" are ignored.
//Output:
//"Hello how are you"

public class _12_Truncate_Sentence {

    public String truncateSentence(String s, int k) {
        String[] words = s.split(" "); // Split sentence into words
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < k; i++) {
            result.append(words[i]).append(" ");
        }

        return result.toString().trim(); // Remove extra space at the end
    }

    public static void main(String[] args) {
        _12_Truncate_Sentence obj = new _12_Truncate_Sentence();
        System.out.println(obj.truncateSentence("Hello how are you Contestant", 4)); // Output: "Hello how are you"
        System.out.println(obj.truncateSentence("What is the solution to this problem", 2)); // Output: "What is"
    }
}
