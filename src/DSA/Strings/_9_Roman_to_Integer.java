package DSA.Strings;

public class _9_Roman_to_Integer {

    public int num(char c) {
        if (c == 'I') {
            return 1;
        } else if (c == 'V') {
            return 5;
        } else if (c == 'X') {
            return 10;
        } else if (c == 'L') {
            return 50;
        } else if (c == 'C') {
            return 100;
        } else if (c == 'D') {
            return 500;
        }

        return 1000;
    }

    public int romanToInt(String s) {
        if (s == null) {
            return 0;
        }

        int index = 0;
        int sum = 0;

        while (index < s.length() - 1) {
            if (num(s.charAt(index)) < num(s.charAt(index + 1))) {
                sum = sum - num(s.charAt(index));
            } else {
                sum = sum + num(s.charAt(index));
            }

            index++;
        }

        sum = sum + num(s.charAt(index));

        return sum;
    }

    public static void main(String[] args) {

    }
}
