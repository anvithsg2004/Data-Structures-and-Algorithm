package DSA.Practice.Strings.Leetcode_Easy;

import javax.swing.plaf.IconUIResource;

public class _9_Maximum_Number_of_Words_Found_in_Sentences {

    public int mostWordsFound(String[] sentences) {

        int maxi = 0;

        for (int i = 0; i < sentences.length; i++) {

            int count = 0;

            for (int j = 0; j < sentences[i].length(); j++) {
                if (sentences[i].charAt(j) == ' ') {
                    count++;
                }
            }

            maxi = Math.max(maxi, count + 1);
        }

        return maxi;

    }

    public static void main(String[] args) {

    }
}
