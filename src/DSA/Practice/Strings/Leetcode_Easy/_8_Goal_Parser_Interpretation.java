package DSA.Practice.Strings.Leetcode_Easy;

public class _8_Goal_Parser_Interpretation {

    public String interpret(String command) {

        StringBuilder result = new StringBuilder();

        StringBuilder middle = new StringBuilder();

        for (int i = 0; i < command.length(); i++) {

            if (middle.toString().equals("(al)")) {
                result.append("al");
                middle.setLength(0);
            }

            if (middle.toString().equals("()")) {
                result.append("o");
                middle.setLength(0);
            }

            if (middle.toString().equals("G")) {
                result.append("G");
                middle.setLength(0);
            }

            middle.append(command.charAt(i));

        }

        // Check for the last part of the command if middle has leftover characters
        if (middle.length() > 0) {
            if (middle.toString().equals("G")) {
                result.append("G");
            } else if (middle.toString().equals("()")) {
                result.append("o");
            } else if (middle.toString().equals("(al)")) {
                result.append("al");
            }
        }

        return result.toString();

    }


    public static void main(String[] args) {

    }
}
