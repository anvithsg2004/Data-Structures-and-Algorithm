package DSA.Strings;

import java.util.*;

public class _25_Sum_of_Beauty_of_All_Substrings {

    //Given a string s, the beauty of a substring is defined as the difference
    //between the most frequent and the least frequent character counts in that substring.
    //The task is to calculate the sum of beauty values for all possible substrings of s.

    public int beautySum(String s) {

        int n = s.length();

        if (n == 0) {
            return 0;
        }

        Map<Character, Integer> frequency = new HashMap<>();

        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                frequency.put(s.charAt(j), frequency.getOrDefault(s.charAt(j), 0) + 1);

                if (frequency.size() >= 2) {
                    int maxi = Collections.max(frequency.values());
                    int mini = Collections.min(frequency.values());

                    sum = sum + (maxi - mini);
                }

            }

            frequency.clear();
        }

        return sum;

    }
}
