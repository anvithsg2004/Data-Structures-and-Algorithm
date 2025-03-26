package DSA.Practice.Strings.Leetcode_Easy;

//Count Prefix and Suffix Pairs I
//You are given an array of strings words.
//A pair of words (words[i], words[j]) is considered valid if:
//words[i] is both a prefix and suffix of words[j].
//i < j (to avoid duplicate pairs).
//Return the total count of such valid pairs.

//Input:
//String[] words = {"abc", "ab", "abcabc", "a", "abcabcabc"};

//Output:
//2

//Explanation:
//"abc" is both a prefix and suffix of "abcabc" → Valid pair ("abc", "abcabc")
//"abc" is both a prefix and suffix of "abcabcabc" → Valid pair ("abc", "abcabcabc")
//"ab", "a", and other words do not form valid pairs.

public class _19_Count_Prefix_and_Suffix_Pairs_I {

    public int countPrefixSuffixPairs(String[] words) {

        int count = 0;

        int n = words.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;

    }

    public boolean isPrefixAndSuffix(String str1, String str2) {
        int oneLength = str1.length();
        int secondLength = str2.length();

        if ((2 * secondLength) > oneLength && secondLength >= oneLength) {
            String frontPart = str2.substring(0, oneLength);
            String lastPart = str2.substring(secondLength - oneLength);

            if (frontPart.equals(str1) && lastPart.equals(str1)) {
                return true;
            }
        }

        return false;
    }

}
