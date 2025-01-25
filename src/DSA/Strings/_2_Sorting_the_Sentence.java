package DSA.Strings;

public class _2_Sorting_the_Sentence {

    public String sortSentence(String s) {
        if (s == null) {
            return null;
        }

        // Create an array to hold the words in their correct positions
        String[] answer = new String[10];
        int index = 0;
        int count = 0;
        StringBuilder temp = new StringBuilder();

        while (index < s.length()) {
            if (s.charAt(index) == ' ') {
                // Get the position of the word (last character of temp)
                int position = temp.charAt(temp.length() - 1) - '0';

                // Remove the last digit which indicates the position
                temp.deleteCharAt(temp.length() - 1);

                // Store the word in the corresponding position (1-based index)
                answer[position - 1] = temp.toString();  // Adjust to 0-based index

                // Clear temp for the next word
                temp.setLength(0);

                count++;
            } else {
                temp.append(s.charAt(index));
            }

            index++;
        }

        // Handle the last word (since it won't end with a space)
        int position = temp.charAt(temp.length() - 1) - '0';
        temp.deleteCharAt(temp.length() - 1);
        answer[position - 1] = temp.toString();

        // Build the final sentence
        temp.setLength(0);
        for (int i = 0; i < count + 1; i++) {  // Loop for the number of words including the last words.
            temp.append(answer[i]);
            if (i < count) {
                temp.append(' ');  // Add space between words
            }
        }

        return temp.toString();
    }

    public static void main(String[] args) {

    }
}
