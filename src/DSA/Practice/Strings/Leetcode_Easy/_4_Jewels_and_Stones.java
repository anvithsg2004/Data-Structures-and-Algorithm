package DSA.Practice.Strings.Leetcode_Easy;

import java.util.HashSet;

public class _4_Jewels_and_Stones {

    public int numJewelsInStones(String jewels, String stones) {

        HashSet<Character> check = new HashSet<>();

        for (int i = 0; i < jewels.length(); i++) {
            check.add(jewels.charAt(i));
        }

        int count = 0;

        for (int i = 0; i < stones.length(); i++) {
            if (check.contains(stones.charAt(i))) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
