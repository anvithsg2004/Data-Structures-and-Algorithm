package DSA.Practice.Strings.Leetcode_Easy;

import java.util.HashSet;

public class _4_Jewels_and_Stones {

    //You are given two strings:
    //jewels → A string representing the types of stones that are "jewels."
    //stones → A string representing stones you have.

    //💎 Each character in jewels is a type of jewel.
    //💎 You need to count how many characters in stones are also jewels.

    //Input
    //jewels = "aA"
    //stones = "aAAbbbb"

    //Step 1: Identify Jewels
    //jewels = "aA" → The jewels are { 'a', 'A' }.
    //Step 2: Count Matching Stones
    //stones = "aAAbbbb"
    //Only 'a' and 'A' are jewels.
    //The count is 3.

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
