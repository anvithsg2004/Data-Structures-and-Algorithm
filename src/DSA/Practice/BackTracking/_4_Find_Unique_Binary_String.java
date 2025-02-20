package DSA.Practice.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4_Find_Unique_Binary_String {
    public static String findDifferentBinaryString(String[] nums) {

        List<String> givenStrings = new ArrayList<>(Arrays.asList(nums));

        int n = nums[0].length();

        List<String> allSubSets = allSubsets(n);

        for (int i = 0; i < allSubSets.size(); i++) {
            if (!givenStrings.contains(allSubSets.get(i))) {
                return allSubSets.get(i);
            }
        }

        return "";

    }

    public static List<String> allSubsets(int n) {

        StringBuilder mainString = new StringBuilder();

        for (int i = 0; i < n; i++) {
            mainString.append('0');
        }

        List<String> allSubSet = new ArrayList<>();

        int totalSubSets = (1 << n);

        for (int i = 0; i < totalSubSets; i++) {

            StringBuilder number = new StringBuilder(mainString);

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    number.setCharAt(j, '1'); // Correct way to modify StringBuilder
                }
            }

            allSubSet.add(number.toString()); // Add the generated subset representation
        }

        return allSubSet;
    }

    public static void main(String[] args) {
        String[] nums = {"01", "10"};
        System.out.println(findDifferentBinaryString(nums));
    }

}
