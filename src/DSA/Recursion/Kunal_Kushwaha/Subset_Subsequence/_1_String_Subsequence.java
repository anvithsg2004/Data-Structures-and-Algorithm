package DSA.Recursion.Kunal_Kushwaha.Subset_Subsequence;

public class _1_String_Subsequence {

    public static void subStr(String processed, String unProcessed) {

        if (unProcessed.isEmpty()) {
            System.out.println(processed);
            return;
        }

        char ch = unProcessed.charAt(0);

        //Do not take the character
        subStr(processed, unProcessed.substring(1));

        //Take the character
        subStr(processed + ch, unProcessed.substring(1));

    }

    public static void main(String[] args) {

        subStr("", "anvith");

    }
}
