package DSA.Strings;

import java.util.Arrays;

//Given an array of strings strs, find the longest common prefix
//among all the strings. If there is no common prefix, return an empty string "".
//Example 1:
//Input:
//strs = ["flower", "flow", "flight"]
//Output:
//"fl"
//Explanation:
//The longest common prefix among "flower", "flow", and "flight" is "fl".

//we compare only the first and last strings after sorting

public class _20_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {

        //Step 1: Sorting the Array
        //Before sorting: ["dog", "racecar", "car"]
        //After sorting: ["car", "dog", "racecar"]
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length - 1];

        int index = 0;

        while (index < str1.length()) {
            if (str1.charAt(index) == str2.charAt(index)) {
                index++;
            } else {
                break;
            }
        }

        return index == 0 ? "" : str1.substring(0, index);

    }
}
