package DSA.Practice.BackTracking;

import java.util.*;

public class _7_Combinations {

    public static List<List<Integer>> combine(int n, int k) {

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }

        List<List<Integer>> answer = new ArrayList<>();

        helper(answer, new ArrayList<>(), k, numbers, 0);

        return answer;

    }

    public static void helper(List<List<Integer>> answer, List<Integer> current, int k, int[] numbers, int index) {

        if (current.size() == k) {
            answer.add(new ArrayList<>(current));
            return;
        }

        if (index >= numbers.length) {
            return;
        }

        //Pick
        current.add(numbers[index]);
        helper(answer, current, k, numbers, index + 1);

        current.remove(current.size() - 1);

        //Not Pick
        helper(answer, current, k, numbers, index + 1);

    }

    public static void main(String[] args) {

        int n = 4;
        int k = 2;
        combine(n, k);

    }

}
