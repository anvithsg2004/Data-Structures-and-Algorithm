package DSA.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class _9_Longest_Substring_with_At_Most_K_Distinct_Characters {
    public int fun(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        Map<Character, Integer> mpp = new HashMap<>();
        int maxLenght = 0;
        int left = 0;
        int right = 0;

        for (right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            mpp.put(c, mpp.getOrDefault(c, 0) + 1);

            while (mpp.size() > k) {
                char leftChar = s.charAt(left);
                mpp.put(leftChar, mpp.get(leftChar) - 1);
                if (mpp.get(leftChar) == 0) {
                    mpp.remove(leftChar);
                }
                left++;
            }
            maxLenght = Math.max(maxLenght, right - left + 1);
        }

        return maxLenght;
    }
}
