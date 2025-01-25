package DSA.Strings;

public class _19_Rotate_String {

    public boolean rotateString(String s, String goal) {

        return s.length() == goal.length() && (s + s).contains(goal);

    }

    public static void main(String[] args) {

    }
}
