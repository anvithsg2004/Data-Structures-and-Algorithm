package DSA.Practice.Strings.Leetcode_Medium;

import java.util.ArrayList;
import java.util.HashMap;

public class _18_Decode_the_string {
    public static String decodeString(String s) {

        int n = s.length();

        StringBuilder result = new StringBuilder();

        StringBuilder newS = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == ']') {
                newS.append(" ");
            } else {
                newS.append(s.charAt(i));
            }
        }

        System.out.println(newS);

        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int number = Character.getNumericValue(newS.charAt(i));
            numbers.add(number);
        }

        for (int i = 0; i < n; i++) {
            
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "3[b2[ca]]";
        decodeString(s);
    }
}
