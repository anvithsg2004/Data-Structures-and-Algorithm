package DSA.Practice.Strings.Leetcode_Easy;

public class _11_Reverse_Prefix_of_Word {

    public String reversePrefix(String word, char ch) {

        StringBuilder result = new StringBuilder();

        StringBuilder middle = new StringBuilder();

        boolean isThere = true;

        int start = 0;
        int end = 0;

        for (int i = 0; i < word.length(); i++) {

            if (word.charAt(i) == ch) {
                isThere = false;
                middle.append(word.charAt(i));
                middle.reverse();
                result.append(middle);
                break;
            }

            middle.append(word.charAt(i));

            end++;

        }

        for (int i = end + 1; i < word.length(); i++) {
            result.append(word.charAt(i));
        }

        if (isThere == true) {
            return word;
        }

        return result.toString();

    }

    public static void main(String[] args) {

    }
}
