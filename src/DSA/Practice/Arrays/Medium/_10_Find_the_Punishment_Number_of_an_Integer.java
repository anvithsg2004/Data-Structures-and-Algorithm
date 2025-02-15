package DSA.Practice.Arrays.Medium;

public class _10_Find_the_Punishment_Number_of_an_Integer {

    public static int punishmentNumber(int n) {

        int sum = 0;

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (helper(i)) {
                sum = sum + (i * i);
                count++;
            }
        }

        System.out.println(count);

        return sum;

    }

    public static boolean helper(int num) {

        int square = num * num;

        //Convert int to String
        String intToString = String.valueOf(square);

        int n = intToString.length();

        for (int i = 0; i < n; i++) {
            int firstNumber = Integer.parseInt(intToString.substring(0, i + 1));
            //For checking if the second number is not empty.
            String secondPart = intToString.substring(i + 1, n);
            int secondNumber = secondPart.isEmpty() ? 0 : Integer.parseInt(secondPart);
            int sum = firstNumber + secondNumber;
            if (sum == num) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(punishmentNumber(37));
    }
}
