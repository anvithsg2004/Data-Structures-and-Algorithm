package DSA.Practice.Strings.Leetcode_Medium;

public class _17_Remove_All_Occurrences_of_a_Substring {
    public static String removeOccurrences(String s, String part) {
        int subLength = part.length();
        StringBuilder result = new StringBuilder(s);

        int index = result.indexOf(part);

        while (index != -1) {
            result.delete(index, index + subLength);
            index = result.indexOf(part);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "daabcbaabcbc";
        String part = "abc";
        System.out.println(removeOccurrences(s, part));
    }
}
