package DSA.Practice.Strings.Leetcode_Easy;

public class _20_Counting_Words_With_a_Given_Prefix {
    public int prefixCount(String[] words, String pref) {

        int n = words.length;

        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean isThere = words[i].startsWith(pref);
            if (isThere) {
                count++;
            }
        }

        return count;

    }
}
