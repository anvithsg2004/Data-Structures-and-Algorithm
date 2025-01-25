package DSA.Practice.Strings.Leetcode_Medium;

public class _9_Remove_All_Occurrences_of_a_Substring {

    public String removeOccurrences(String s, String part) {

        StringBuilder ss = new StringBuilder(s);

        //I will get the starting index of the part String in the SS string.
        //If it is not found, then it will return -1.
        int index = ss.indexOf(part);

        while (index != -1) {

            ss.replace(index, index + part.length(), "");
            index = ss.indexOf(part);

        }

        return ss.toString();

    }

    public static void main(String[] args) {

    }
}
