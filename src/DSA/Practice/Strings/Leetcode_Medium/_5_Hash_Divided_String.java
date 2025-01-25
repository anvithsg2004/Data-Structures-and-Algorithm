package DSA.Practice.Strings.Leetcode_Medium;

import java.util.ArrayList;

public class _5_Hash_Divided_String {

    public String stringHash(String s, int k) {

        ArrayList<Integer> result = new ArrayList<>();

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i = i + k) {

            String middle = s.substring(i, i + k - 1);

            int midSum = 0;

            for (int j = 0; j < middle.length(); j++) {

                midSum = midSum + ( middle.charAt(j) - 'a' );

            }

            result.add(midSum % 26);

        }

        for (int i = 0; i < result.size(); i++) {

            char letter = (char) ('a' + result.get(i));

            res.append(letter);

        }

        return res.toString();

    }

    public static void main(String[] args) {

    }
}
