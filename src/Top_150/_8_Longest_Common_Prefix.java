package Top_150;

//Given an array of strings strs, return the longest common prefix among all strings in the array.
//If there is no common prefix, return an empty string "".

public class _8_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String prefix = strs[0];  // Start with first word

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);  // Shrink prefix
                if (prefix.isEmpty()) return "";  // No common prefix
            }
        }
        return prefix;
    }
}
