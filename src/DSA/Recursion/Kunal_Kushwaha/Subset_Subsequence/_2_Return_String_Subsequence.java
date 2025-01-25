package DSA.Recursion.Kunal_Kushwaha.Subset_Subsequence;

import java.util.ArrayList;

public class _2_Return_String_Subsequence {

    public static ArrayList<String> strSub(String processed, String unProcessed) {

        if (unProcessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        char ch = unProcessed.charAt(0);

        //Do not take.
        ArrayList<String> left = strSub(processed, unProcessed.substring(1));

        //Take.
        ArrayList<String> right = strSub(processed + ch, unProcessed.substring(1));

        left.addAll(right);

        return left;

    }

    public static void main(String[] args) {

        ArrayList<String> list = strSub("", "anvith");
        System.out.println(list);

    }
}
