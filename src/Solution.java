import java.util.HashMap;
import java.util.Map;

class Solution {
    public int beautySum(String s) {

        int n = s.length();

        int sum = 0;

        for (int i = 0; i < n; i++) {

            Map<Character, Integer> frequencyMap = new HashMap<>();

            for (int j = 0; j <= i; j++) {

                frequencyMap.put(s.charAt(i), frequencyMap.getOrDefault(s.charAt(i), 0) + 1);

            }

            int maxFreq = Integer.MIN_VALUE;
            int minFreq = Integer.MAX_VALUE;

            for (int freq : frequencyMap.values()) {
                maxFreq = Math.max(maxFreq, freq);
                minFreq = Math.min(minFreq, freq);
            }

            int diff = maxFreq - minFreq;

            if (diff != 0) {
                sum = sum + diff;
            }

        }

        return sum;

    }
}
