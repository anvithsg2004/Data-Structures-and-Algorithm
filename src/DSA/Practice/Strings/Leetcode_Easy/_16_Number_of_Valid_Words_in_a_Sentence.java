package DSA.Practice.Strings.Leetcode_Easy;


import java.util.ArrayList;
import java.util.Arrays;

public class _16_Number_of_Valid_Words_in_a_Sentence {

    public int countValidWords(String sentence) {

        String[] words = sentence.split(" ");

        int count = 0;

        for (String word : words) {

            word = word.trim();
            if (word.isEmpty()) {
                continue;
            }

            if (isValid(word)) {
                count++;
            }

        }

        return count;

    }

    public boolean isValid(String word) {

        ArrayList<String> words = new ArrayList<>();
        words.add(word);

        boolean isOther = false;

        for (int i = 0; i < words.size(); i++) {

                if (words.get(i).charAt(i) == '_' || words.get(i).charAt(i) == '!' || words.get(i).charAt(i) == '.' || words.get(i).charAt(i) == ',') {
                    isOther = true;
                }

        }

        return isOther;
    }

    public static void main(String[] args) {

//        System.out.println(Arrays.toString(Arrays.stream(words).toArray()));

    }
}
