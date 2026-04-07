package DSA.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class _9_Longest_Substring_with_At_Most_K_Distinct_Characters {
    public int fun(String s, int k) {
        int n = s.length();

        int i = 0;
        int j = 0;

        Map<Character, Integer> freCount = new HashMap<>();

        int maxLen = -1;

        while (j < n) {

            char letter = s.charAt(j);

            if (freCount.containsKey(letter) == false) {
                freCount.put(letter, 1);
            } else if (freCount.containsKey(letter) == true) {
                freCount.put(letter, freCount.getOrDefault(letter, 0) + 1);
            }

            while (freCount.size() > k) {

                char currentLetter = s.charAt(i);
                freCount.put(currentLetter, freCount.get(currentLetter) - 1);

                if (freCount.get(currentLetter) == 0) {
                    freCount.remove(currentLetter);
                }

                i++;
            }

            if (freCount.size() == k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }

            j++;

        }

        return maxLen;
    }
}
