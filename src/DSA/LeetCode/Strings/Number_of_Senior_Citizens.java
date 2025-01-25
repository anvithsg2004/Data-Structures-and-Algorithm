package DSA.LeetCode.Strings;

public class Number_of_Senior_Citizens {

    public int countSeniors(String[] details) {
        int count = 0;

        for (String s : details) {
            char[] x = s.toCharArray();
            String a = String.valueOf(x[11]) + String.valueOf(x[12]);
            int num = Integer.parseInt(a);
            if (num >= 60) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
