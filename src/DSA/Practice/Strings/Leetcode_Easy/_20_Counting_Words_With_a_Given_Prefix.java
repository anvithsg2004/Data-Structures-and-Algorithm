package DSA.Practice.Strings.Leetcode_Easy;

//Counting Words With a Given Prefix
//You are given an array of strings words and a string pref.
//Your task is to count how many words in words start with the prefix pref.

//Input:
//String[] words = {"apple", "app", "apricot", "banana", "apex"};
//String pref = "ap";

//Output:
//3

//Explanation:
//The words that start with "ap" are:
//"apple"
//"app"
//"apricot" Thus, the output is 3.

public class _20_Counting_Words_With_a_Given_Prefix {
    public int prefixCount(String[] words, String pref) {

        int n = words.length;

        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean isThere = words[i].startsWith(pref);
            if (isThere) {
                count++;
            }
        }

        return count;

    }
}
