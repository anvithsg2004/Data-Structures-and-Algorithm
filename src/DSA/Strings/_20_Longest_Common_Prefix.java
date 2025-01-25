package DSA.Strings;

import java.util.Arrays;

public class _20_Longest_Common_Prefix {

    public String longestCommonPrefix(String[] strs) {

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

    public static void main(String[] args) {

    }
}
