package DSA.Recursion;

public class _2_Palindrome_String_Or_Not {

    public boolean palindrome(String s) {
        int n = s.length();
        return helper(s, 0);
    }

    public boolean helper(String s, int i) {
        if (s.length() / 2 <= i) {
            return true;
        }

        if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
            return false;
        }

        return helper(s, i + 1);
    }

    public static void main(String[] args) {

    }
}
