package DSA.Sliding_Window;

public class _7_Number_of_Substrings_Containing_All_Three_Characters {

    public int numberOfSubstrings(String s) {
        int[] count = new int[3];  // 'a' -> 0, 'b' -> 1, 'c' -> 2
        int left = 0, result = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'a']++;

            // While window contains all three characters
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result = result + (s.length() - right);  // all substrings from left to end are valid
                count[s.charAt(left) - 'a']--; // shrink window
                left++;
            }
        }

        return result;
    }
}
