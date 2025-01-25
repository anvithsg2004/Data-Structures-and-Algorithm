package DSA.Practice.Strings.Leetcode_Easy;

public class _14_Shuffle_String {

    public String restoreString(String s, int[] indices) {
        // Create a char array to store the result directly
        char[] result = new char[s.length()];

        // Place characters at their correct positions based on the indices array
        for (int i = 0; i < s.length(); i++) {
            result[indices[i]] = s.charAt(i);
        }

        // Convert the char array back to a String and return
        return new String(result);
    }

    public static void main(String[] args) {

    }
}
