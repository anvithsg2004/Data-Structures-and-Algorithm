package DSA.Practice.Binary_Search.Medium;

public class _16_Nth_Digit {

    ///Not completed

    public int findNthDigit(int n) {

        if (n >= 0 && n <= 9) {

            return n;

        } else if (n >= 10 && n <= 99) {

            if (n % 2 == 1) {

                int rightSide = ((n - 10) / 2) + 1;

                return (n - rightSide) % 10;

            } else {

                int leftSide = (n - 10) / 2;

                return (n - leftSide) / 10;

            }

        } else if (n >= 100 && n <= 999) {


        }

        return -1;

    }

    public static void main(String[] args) {

    }
}
