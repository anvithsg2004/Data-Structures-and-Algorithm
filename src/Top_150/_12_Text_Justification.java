package Top_150;

//🧩 Problem Statement:
//Given:
//words[]: list of words.
//maxWidth: integer for line width.
//Return a list of lines, where each line is fully justified.

//Input:
//words = ["This", "is", "an", "example", "of", "text", "justification."]
//maxWidth = 16
//Output:
//[
//"This    is    an",
//"example  of text",
//"justification.  "
//]

//⚙️ Key Rules:
//Distribute spaces evenly between words.
//Extra spaces go leftmost if they can't be evenly split.
//Last line = left-justified, spaces at the end.

import java.util.ArrayList;
import java.util.List;

public class _12_Text_Justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int lineLen = words[i].length();
            int j = i + 1;

            // Find how many words fit in this line
            while (j < words.length && lineLen + words[j].length() + (j - i) <= maxWidth) {
                lineLen += words[j].length();
                j++;
            }

            int wordCount = j - i;
            int totalSpaces = maxWidth - lineLen;

            StringBuilder line = new StringBuilder();
            // Last line or single word line = left-justified
            if (j == words.length || wordCount == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k != j - 1) line.append(" ");
                }
                // Fill remaining space
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int spaceBetween = totalSpaces / (wordCount - 1);
                int extraSpaces = totalSpaces % (wordCount - 1);
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k != j - 1) {
                        for (int s = 0; s < spaceBetween + (k - i < extraSpaces ? 1 : 0); s++) {
                            line.append(" ");
                        }
                    }
                }
            }
            result.add(line.toString());
            i = j;
        }

        return result;
    }
}
