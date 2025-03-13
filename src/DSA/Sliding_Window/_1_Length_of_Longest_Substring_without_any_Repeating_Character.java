package DSA.Sliding_Window;

import java.util.*;

public class _1_Length_of_Longest_Substring_without_any_Repeating_Character {

    //Optimal
    public int solve(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        int n = s.length();

        int left = 0;
        int right = 0;
        int len = 0;

        while (right < n) {
            if (hashMap.containsKey(s.charAt(right))) {
                left = Math.max(hashMap.get(s.charAt(right)) + 1, left);
            }

            hashMap.put(s.charAt(right), right);

            len = Math.max(len, right - left + 1);
            right++;
        }

        return len;

    }

    public int fun(String str) {
        if (str.isEmpty()) {
            return 0;
        }

        int maxAns = 0; // Initialize to 0
        for (int i = 0; i < str.length(); i++) {
            Set<Character> se = new HashSet<>();
            for (int j = i; j < str.length(); j++) {
                if (se.contains(str.charAt(j))) {
                    break;
                }
                se.add(str.charAt(j));
                int len = j - i + 1;
                maxAns = Math.max(len, maxAns);
            }
        }
        return maxAns;
    }
}
