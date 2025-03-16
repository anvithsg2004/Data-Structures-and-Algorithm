package Top_150;

//🧪 Example Dry Run:
//Example 1:
//haystack = "sadbutsad"
//needle = "sad"
//"sad" appears at index 0 and index 6, but we return 0 because it’s the first occurrence.

public class _11_Find_the_Index_of_the_First_Occurrence_in_a_String {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStr2(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m == 0) return 0;

        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
