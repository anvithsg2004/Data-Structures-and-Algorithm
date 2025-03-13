package DSA.Greedy_Algorithms;

import java.util.*;

public class _5_Valid_Parenthesis {

    //When "*" is found, you three options ⇒
    //1) Simply leave the space.
    //2) Fill it with "(".
    //3) Fill it with ")".

    //Recursion
    public boolean checkValidString(String s) {

        //So if the string length is 1, and it is "*", then return true.
        if (s.length() == 1 && s.charAt(0) == '*') {
            return true;
        }

        //Any other like ")" or "(" then return false.
        if (s.length() == 1) {
            return false; // A single character string cannot be valid
        }

        return helper(s, 0, 0);
    }

    //The helper function is just simple. If "(",
    //then increase the count or else decrease the count.
    public boolean helper(String s, int index, int count) {
        // If the count goes negative, it's invalid
        if (count < 0) {
            return false;
        }

        // If we reach the end of the string, check if all parentheses are balanced
        if (index == s.length()) {
            return count == 0;
        }

        // Handle each character
        if (s.charAt(index) == '(') {
            return helper(s, index + 1, count + 1);
        }

        if (s.charAt(index) == ')') {
            return helper(s, index + 1, count - 1);
        }

        if (s.charAt(index) == '*') {
            return helper(s, index + 1, count + 1)  // Treat * as '('
                    || helper(s, index + 1, count - 1)  // Treat * as ')'
                    || helper(s, index + 1, count);  // Treat * as empty
        }

        // If none of the above, return false
        return false;
    }

    //Memoization
    public boolean checkValidString2(String s) {
        if (s.length() == 1 && s.charAt(0) == '*') {
            return true;
        }

        if (s.length() == 1) {
            return false; // A single character string cannot be valid
        }

        // Initialize the memoization map
        Map<String, Boolean> memo = new HashMap<>();
        return helper2(s, 0, 0, memo);
    }

    public boolean helper2(String s, int index, int count, Map<String, Boolean> memo) {
        // If the count goes negative, it's invalid
        if (count < 0) {
            return false;
        }

        // If we reach the end of the string, check if all parentheses are balanced
        if (index == s.length()) {
            return count == 0;
        }

        // Create a unique key for the current state
        String key = index + "," + count;

        // Check if the result for this state is already computed
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean result;

        // Handle each character
        if (s.charAt(index) == '(') {
            result = helper2(s, index + 1, count + 1, memo);
        } else if (s.charAt(index) == ')') {
            result = helper2(s, index + 1, count - 1, memo);
        } else if (s.charAt(index) == '*') {
            // Explore all three possibilities for '*'
            result = helper2(s, index + 1, count + 1, memo)
                    || helper2(s, index + 1, count - 1, memo)
                    || helper2(s, index + 1, count, memo);
        } else {
            // If none of the above, return false
            result = false;
        }

        // Store the result in the memoization map
        memo.put(key, result);

        return result;
    }
}
