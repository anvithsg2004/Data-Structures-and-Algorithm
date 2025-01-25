package DSA.Recursion.Kunal_Kushwaha.Introduction;

public class _7_Sum_Of_Digits {

    public static int sumOfDigits(int n) {

        int lastNum = n % 10;
        int LastButDigit = n / 10;

        if (LastButDigit == 0) {
            return lastNum;
        }

        return lastNum + sumOfDigits(LastButDigit);

    }

    public static void main(String[] args) {

        int n = 1234;
        System.out.println(sumOfDigits(n));

    }
}
