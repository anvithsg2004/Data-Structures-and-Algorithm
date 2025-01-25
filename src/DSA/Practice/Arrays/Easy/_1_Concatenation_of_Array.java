package DSA.Practice.Arrays.Easy;

import java.util.ArrayList;
import java.util.Arrays;

public class _1_Concatenation_of_Array {

    //Optimal Code
    public int[] getConcatenation2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        System.arraycopy(nums, 0, ans, 0, n);
        System.arraycopy(nums, 0, ans, n, n);
        return ans;
    }

    //Brute Force Code
    public int[] getConcatenation(int[] nums) {

        int n = nums.length;

        ArrayList<Integer> result = new ArrayList<>();

        for (int num : nums) {
            result.add(num);
        }

        for (int num : nums) {
            result.add(num);
        }

        int[] res = new int[2 * n];

        for (int i = 0; i < result.size(); i++) {

            res[i] = result.get(i);

        }

        return res;
    }

    public static void main(String[] args) {

    }
}
