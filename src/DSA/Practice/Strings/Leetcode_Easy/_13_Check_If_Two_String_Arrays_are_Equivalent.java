package DSA.Practice.Strings.Leetcode_Easy;

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
