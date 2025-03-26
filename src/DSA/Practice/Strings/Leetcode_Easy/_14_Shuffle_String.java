package DSA.Practice.Strings.Leetcode_Easy;

public class _14_Shuffle_String {

    //You are given a string s and an integer array indices, where indices[i] represents the position
    //where s.charAt(i) should be placed in the shuffled string.
    //Your task is to restore the original string based on the given indices.

    //Input:
    //s = "codeleet";
    //indices = [4,5,6,7,0,2,1,3];

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
