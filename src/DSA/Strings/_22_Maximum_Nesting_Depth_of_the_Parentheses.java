package DSA.Strings;

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

    public static void main(String[] args) {

    }
}
