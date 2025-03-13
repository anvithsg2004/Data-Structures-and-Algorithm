package DSA.Strings;

//Input: s = "(1+(2*3)+((8)/4))+1"
//Output: 3
//Explanation:
//- The deepest nested part is "((8)/4)" which has depth = 3.

//Input: s = "(1)+((2))+(((3)))"
//Output: 3
//Explanation: The maximum depth is found in "(((3)))".

//Input: s = "1+(2*3)/(2-1)"
//Output: 1
//Explanation: There is only one level of nesting.

//Input: s = "1"
//Output: 0
//Explanation: There are no parentheses.

public class _22_Maximum_Nesting_Depth_of_the_Parentheses {
    public int maxDepth(String s) {

        int count = 0;

        int maxi = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
            }

            maxi = Math.max(maxi, count);

        }

        return maxi;

    }
}
