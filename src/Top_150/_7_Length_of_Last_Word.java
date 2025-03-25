package Top_150;

//Given a string s consisting of words and spaces, return the length of the last word in the string.
//A word is a maximal substring consisting of non-space characters only.

//🧪 Example:
//Input: "Hello World"
//Output: 5
//Explanation: The last word is "World" with length 5.

//Skip trailing spaces:
//Check: s.charAt(10) = 'd' → not a space, so this loop is skipped.
//Count characters of the last word: Loop: while (i >= 0 && s.charAt(i) != ' ')
//i = 10 → 'd' ≠ ' ' → length = 1 → i = 9
//i = 9 → 'l' ≠ ' ' → length = 2 → i = 8
//i = 8 → 'r' ≠ ' ' → length = 3 → i = 7
//i = 7 → 'o' ≠ ' ' → length = 4 → i = 6
//i = 6 → 'W' ≠ ' ' → length = 5 → i = 5
//i = 5 → ' ' → loop exits.

public class _7_Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count characters of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}
