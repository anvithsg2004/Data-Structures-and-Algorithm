package neetcode150._3_Sliding_Window;

import java.util.*;

public class _4_Permutation_in_String {
    public static boolean checkInclusion(String s1, String s2) {

        int stringOne = s1.length();
        int stringSecond = s2.length();

        if (stringOne > stringSecond) {
            return false;
        }

        // Store Frequency of String One
        ArrayList<Integer> freOne = new ArrayList<>(Collections.nCopies(26, 0));
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            int index = c - 'a';
            freOne.set(index, freOne.get(index) + 1);
        }

        int windowLength = stringOne;

        int right = 0;

        while (right + windowLength <= stringSecond) {

            String subString = s2.substring(right, right + windowLength);

            if (doesContainPermutation(s1, subString, freOne)) {
                return true;
            }

            right = right + 1;

        }

        return false;

    }

    public static boolean doesContainPermutation(String s1, String s2, ArrayList<Integer> freOne) {

        ArrayList<Integer> freTwo = new ArrayList<>(freOne);

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            int index = c - 'a';
            freTwo.set(index, freTwo.get(index) - 1);
        }

        for (int i = 0; i < freTwo.size(); i++) {
            if (freTwo.get(i) != 0) {
                return false;
            }
        }

        return true;

    }

}
