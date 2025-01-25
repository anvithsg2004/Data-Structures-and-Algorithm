package DSA.Recursion.Kunal_Kushwaha.String;

public class _2_Skip_A_String {

    public static String skipString(String unProcessed) {

        if (unProcessed.isEmpty()) {
            return "";
        }

        if (unProcessed.startsWith("apple")) {
            return skipString(unProcessed.substring(5));
        } else {
            return unProcessed.charAt(0) + skipString(unProcessed.substring(1));
        }

    }

    public static void main(String[] args) {

    }
}
