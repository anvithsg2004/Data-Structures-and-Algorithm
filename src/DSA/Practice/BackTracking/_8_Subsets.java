package DSA.Practice.BackTracking;

import java.util.*;

public class _8_Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        helper(answer, new ArrayList<>(), 0, nums);

        return answer;
    }

    public static void helper(List<List<Integer>> answer, List<Integer> current, int index, int[] givenNumber) {

        if (index == givenNumber.length) { // This base case is enough
            answer.add(new ArrayList<>(current));
            return;
        }

        //Pick
        current.add(givenNumber[index]);
        helper(answer, current, index + 1, givenNumber);

        current.remove(current.size() - 1);

        //Not Pick
        helper(answer, current, index + 1, givenNumber);

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

}
