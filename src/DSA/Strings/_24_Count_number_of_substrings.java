package DSA.Strings;

import java.util.*;

//Count Number of Substrings with Exactly K Unique Characters
//The problem is to find the number of substrings in a given
//string s that contain exactly k distinct (unique) characters.
public class _24_Count_number_of_substrings {
    public static long substrCount(String s, int k) {

        //Why help(s, k) - help(s, k - 1)?
        //It is hard to count substrings with exactly k distinct characters directly.
        //But it is easy to count substrings with at most k distinct characters.
        //So, we first count:
        //✅ Substrings with at most k distinct characters → help(s, k)
        //✅ Substrings with at most k - 1 distinct characters → help(s, k - 1)
        //Then, we subtract them to get exactly k distinct characters:
        //Exactly ‘k‘ distinct = At most ‘k‘ − At most ‘k-1‘

        //Think of it Like Counting Groups
        //Suppose we have:
        //Type of Substrings	                        Count
        //Substrings with at most 3 distinct characters	42
        //Substrings with at most 2 distinct characters	30
        //Substrings with exactly 3 distinct characters	42 - 30 = 12
        //This works because "at most 3" already includes everything up to 3, and "at most 2"
        //removes the ones with only 2 or fewer distinct characters.
        return help(s, k) - help(s, k - 1);

    }

    public static long help(String s, int k) {

        int right;
        int left = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);

            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while (map.size() > k) {

                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;

            }

            count = count + (right - left + 1);

        }

        return count;

    }
}
