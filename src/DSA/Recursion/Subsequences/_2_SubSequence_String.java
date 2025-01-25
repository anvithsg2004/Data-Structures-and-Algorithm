package DSA.Recursion.Subsequences;

import java.util.List;

public class
_2_SubSequence_String {

    public void printSubsequences(String str, int index, List<Character> current) {
        if (index == str.length()) {
            System.out.println(current);
            return;
        }

        // Recursive case: two choices for every character

        // Include the current character in the subsequence
        current.add(str.charAt(index));
        printSubsequences(str, index + 1, current);

        // Backtrack to exclude the current character
        current.remove(str.charAt(index));
        printSubsequences(str, index + 1, current);
    }

    public static void main(String[] args) {

    }
}
