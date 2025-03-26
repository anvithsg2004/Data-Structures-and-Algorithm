package DSA.Practice.Strings.Leetcode_Easy;

public class _9_Maximum_Number_of_Words_Found_in_Sentences {

    //This program finds the sentence with the maximum number of words in a given array of sentences.

    //Input: sentences = ["I love Java", "DSA is fun", "Spring Boot is powerful"]
    //Output: 4

    //"I love Java" → 3 words
    //"DSA is fun" → 3 words
    //"Spring Boot is powerful" → 4 words
    //Maximum = 4

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

    //Optimal
    public int mostWordsFound2(String[] sentences) {
        int maxi = 0;

        for (String sentence : sentences) {
            int count = sentence.split(" ").length;
            maxi = Math.max(maxi, count);
        }

        return maxi;
    }


    public static void main(String[] args) {

    }
}
