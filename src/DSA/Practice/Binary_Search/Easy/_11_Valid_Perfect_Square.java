package DSA.Practice.Binary_Search.Easy;

public class _11_Valid_Perfect_Square {

    //In the Binary Search, if I get Time Limit Exceeded then use 'long'.

    public boolean isPerfectSquare(int num) {

        long low = 0;
        long high = num;

        while (low <= high) {

            long mid = (low + high) / 2;

            long mul = mid * mid;

            if (mul == num) {

                return true;

            } else if (mul > num) {

                high = mid - 1;

            } else {

                low = mid + 1;

            }

        }

        return false;

    }

    public static void main(String[] args) {

    }
}
