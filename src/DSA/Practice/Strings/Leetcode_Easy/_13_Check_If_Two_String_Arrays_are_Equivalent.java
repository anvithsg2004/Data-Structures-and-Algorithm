package DSA.Practice.Strings.Leetcode_Easy;

//You are given two string arrays, word1 and word2.
//You need to check whether their concatenated forms are equal.

//Input:
//word1 = ["ab", "c"];
//word2 = ["a", "bc"];
//Process:
//Concatenating word1 → "ab" + "c" → "abc"
//Concatenating word2 → "a" + "bc" → "abc"
//Both are equal, so return true.

public class _13_Check_If_Two_String_Arrays_are_Equivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // Join the strings in word1
        StringBuilder str1 = new StringBuilder();
        for (String word : word1) {
            str1.append(word);
        }

        // Join the strings in word2
        StringBuilder str2 = new StringBuilder();
        for (String word : word2) {
            str2.append(word);
        }

        // Compare the two resulting strings
        return str1.toString().equals(str2.toString());
    }

    public static void main(String[] args) {

    }
}
