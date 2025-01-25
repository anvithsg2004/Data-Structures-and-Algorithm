package DSA.Practice.Strings.Leetcode_Easy;

public class _12_Truncate_Sentence {

    public String truncateSentence(String s, int k) {

        int index = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {

                if (index + 1 == k) {
                    break;
                }

                index++;
            }

            result.append(s.charAt(i));
        }

        return result.toString();

    }

    public static void main(String[] args) {

    }
}
