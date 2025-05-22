package DSA.Strings;

import java.util.Stack;

//Given Input: "(()())(())"

//Index	Char	Stack Size Before	Action	        Stack Size After	Result (sb)
//0	    (	        0	            Skip (outer)	        1	            ""
//1	    (	        1	            Append	                2	            "("
//2	    )	        2	            Append	                1	            "()"
//3	    (	        1	            Append	                2	            "()("
//4	    )	        2	            Append	                1	            "()()"
//5	    )	        1	            Skip (outer)	        0	            "()()"
//6	    (	        0	            Skip (outer)	        1	            "()()"
//7	    (	        1	            Append	                2	            "()()("
//8	    )	        2	            Append	                1	            "()()()"
//9	    )	        1	            Skip (outer)	        0	            "()()()"

public class _14_Remove_Outermost_Parentheses {
    public String removeOuterParentheses(String s) {

        Stack<Character> bracket = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                if (bracket.size() > 0) {
                    sb.append(s.charAt(i));
                }
                bracket.push('(');
            } else {
                bracket.pop();
                if (bracket.size() > 0) {
                    sb.append(s.charAt(i));
                }
            }

        }

        return sb.toString();

    }
}
