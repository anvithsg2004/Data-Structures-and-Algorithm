package DSA.Practice.Arrays.Easy;

public class _19_Count_Symmetric_Integers {
    public static int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for (int i = low; i <= high; i++) {

            StringBuilder sb = new StringBuilder(String.valueOf(i));

            if (sb.length() % 2 == 0) {
                if (fun(i)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean fun(int n) {

        StringBuilder sb = new StringBuilder(String.valueOf(n));

        StringBuilder firstHalf = new StringBuilder(sb.substring(0, (sb.length() / 2)));

        System.out.println("First Half : " + firstHalf);

        int firstHalfSum = 0;

        for (int i = 0; i < firstHalf.length(); i++) {
            char ch = firstHalf.charAt(i);
            firstHalfSum += ch - '0';
        }

        StringBuilder secondHalf = new StringBuilder(sb.substring(sb.length() / 2));

        System.out.println("Second Half : " + secondHalf);

        int secondHalfSum = 0;

        for (int i = 0; i < secondHalf.length(); i++) {
            char ch = secondHalf.charAt(i);
            secondHalfSum += ch - '0';
        }

        return firstHalfSum == secondHalfSum;

    }

    public static void main(String[] args) {

        int low = 10;
        int high = 100;

        System.out.println(countSymmetricIntegers(low, high));

    }
}
