package DSA.Practice.Strings.Leetcode_Easy;

public class _6_Convert_Date_to_Binary {

    //You have a date string in the format "YYYY-MM-DD", and you need to convert each part (Year, Month, Day)
    //into binary while keeping them separated by '-'.

    //Input
    //date = "2024-03-25";

    //Processing
    //"2024" → Convert to binary → "111111001000"
    //"03" → Convert to binary → "11"
    //"25" → Convert to binary → "11001"

    //Output
    //"111111001000-11-11001"

    public String convertDateToBinary(String date) {

        StringBuilder result = new StringBuilder();

        StringBuilder middle = new StringBuilder();

        int num;

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

        //✅ Example
        //For "2024-03-25",
        //"25" is collected in middle, but there is no hyphen after it.
        //Without this block, "25" wouldn't be converted and added to result.
        // Handle the last number after the last hyphen
        if (middle.length() > 0) {
            num = Integer.parseInt(middle.toString());
            binary = Integer.toBinaryString(num);
            result.append(binary);
        }

        //✅ Example Before removing hyphen:
        //"111111001000-11-11001-"
        //After correction:
        //"111111001000-11-11001"
        // Remove the last hyphen if it exists
        if (result.length() > 0 && result.charAt(result.length() - 1) == '-') {
            result.setLength(result.length() - 1);
        }

        return result.toString();

    }

    public static void main(String[] args) {

    }
}
