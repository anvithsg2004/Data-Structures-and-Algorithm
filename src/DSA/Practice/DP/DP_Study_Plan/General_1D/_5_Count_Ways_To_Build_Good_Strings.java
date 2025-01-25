package DSA.Practice.DP.DP_Study_Plan.General_1D;

import java.util.HashMap;
import java.util.Map;

public class _5_Count_Ways_To_Build_Good_Strings {


    //Recursion
    public static int countGoodStrings(int low, int high, int zero, int one) {

        String iniOne = "";

        for (int i = 0; i < one; i++) {
            iniOne = iniOne + "1";
        }

        String iniZero = "";

        for (int i = 0; i < zero; i++) {
            iniZero = iniZero + "0";
        }

        return helper(low, high, iniZero, iniOne, "");

    }

    public static int helper(int low, int high, String iniZero, String iniOne, String result) {

        if (result.length() > high) {
            return 0;
        }

        int add = 0;

        if (low <= result.length() && result.length() <= high) {
            add++;
        }

        add = add + helper(low, high, iniZero, iniOne, result + iniZero);
        add = add + helper(low, high, iniZero, iniOne, result + iniOne);

        return add;
    }


    //Memoization
    public int countGoodStrings2(int low, int high, int zero, int one) {

        String iniOne = "";

        for (int i = 0; i < one; i++) {
            iniOne = iniOne + "1";
        }

        String iniZero = "";

        for (int i = 0; i < zero; i++) {
            iniZero = iniZero + "0";
        }

        Map<String, Integer> dp = new HashMap<>();

        return helper2(low, high, iniZero, iniOne, "", dp);

    }

    public int helper2(int low, int high, String iniZero, String iniOne, String result, Map<String, Integer> dp) {

        if (result.length() > high) {
            return 0;
        }

        int add = 0;

        if (low <= result.length() && result.length() <= high) {
            add++;
        }

        if (dp.containsKey(result)) {
            return dp.get(result);
        }

        add = add + helper2(low, high, iniZero, iniOne, result + iniZero, dp);
        add = add + helper2(low, high, iniZero, iniOne, result + iniOne, dp);

        dp.put(result, add);
        return add;

    }

    
    //Optimized Solution
    final int MOD = 1_000_000_007;

    public int countGoodStrings3(int low, int high, int zero, int one) {
        Map<Integer, Integer> dp = new HashMap<>();
        return helper2(low, high, zero, one, 0, dp);
    }

    private int helper2(int low, int high, int zero, int one, int currentLength, Map<Integer, Integer> dp) {
        // If the length exceeds the upper bound, stop recursion
        if (currentLength > high) {
            return 0;
        }

        // Check if the current length is already computed
        if (dp.containsKey(currentLength)) {
            return dp.get(currentLength);
        }

        // Count this string if it's within the range [low, high]
        int count = 0;
        if (low <= currentLength && currentLength <= high) {
            count++;
        }

        // Recursively add the lengths of `zero` and `one`
        count += helper2(low, high, zero, one, currentLength + zero, dp) % MOD;
        count += helper2(low, high, zero, one, currentLength + one, dp) % MOD;

        // Cache the result
        dp.put(currentLength, count);
        return count % MOD;
    }


    public static void main(String[] args) {
        int low = 200;
        int high = 200;
        int zero = 10;
        int one = 1;
        System.out.println(countGoodStrings(low, high, zero, one));
    }

}
