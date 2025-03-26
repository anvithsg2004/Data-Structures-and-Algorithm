package DSA.Practice.Strings.Leetcode_Easy;

import java.util.HashSet;

//This program counts how many words in the given words array only contain characters from the allowed string.

//Input
//allowed = "abc";
//words = ["a", "b", "c", "ab", "bc", "ac", "d", "abc"];

public class _7_Count_the_Number_of_Consistent_Strings {

    public int countConsistentStrings(String allowed, String[] words) {

        HashSet<Character> check = new HashSet<>();

        for (int i = 0; i < allowed.length(); i++) {
            check.add(allowed.charAt(i));
        }

        int count = 0;

        for (int i = 0; i < words.length; i++) {

            boolean isConsistent = true;

            for (int j = 0; j < words[i].length(); j++) {
                if (!check.contains(words[i].charAt(j))) {
                    isConsistent = false;
                    break;
                }
            }


            if (isConsistent) {
                count++;
            }
        }

        return count;

    }

    public static void main(String[] args) {

    }
}
