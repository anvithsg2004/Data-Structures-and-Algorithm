package DSA.Recursion.Kunal_Kushwaha.String;

public class _1_Skip_a_Character {

    public static String skip(String processed) {

        if (processed.isEmpty()) {
            return "";
        }

        if (processed.charAt(0) == 'a') {
            return skip(processed.substring(1));
        } else {
            return processed.charAt(0) + skip(processed.substring(1));
        }

    }

    public static void skip(String processed, String unProcessed) {

        if (unProcessed.isEmpty()) {
            System.out.println(processed);
            return;
        }

        if (unProcessed.charAt(0) == 'a') {
            skip(processed, unProcessed.substring(1));
        } else {
            skip(processed + unProcessed.charAt(0), unProcessed.substring(1));
        }

    }

    public static void main(String[] args) {

    }
}
