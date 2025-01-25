package DSA.Practice.Strings.Leetcode_Easy;

public class _6_Convert_Date_to_Binary {

    public String convertDateToBinary(String date) {

        StringBuilder result = new StringBuilder();

        StringBuilder middle = new StringBuilder();

        int num ;

        String binary;

        for (int i = 0; i < date.length(); i++) {
            if (date.charAt(i) == '-') {
                num = Integer.parseInt(middle.toString());
                binary = Integer.toBinaryString(num);
                result.append(binary);
                result.append('-');
                middle.setLength(0);
            } else {
                middle.append(date.charAt(i));
            }
        }

        // Handle the last number after the last hyphen
        if (middle.length() > 0) {
            num = Integer.parseInt(middle.toString());
            binary = Integer.toBinaryString(num);
            result.append(binary);
        }

        // Remove the last hyphen if it exists
        if (result.length() > 0 && result.charAt(result.length() - 1) == '-') {
            result.setLength(result.length() - 1);
        }

        return result.toString();

    }

    public static void main(String[] args) {

    }
}
