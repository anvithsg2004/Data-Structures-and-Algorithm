

class Solution1 {
    public static void primeorNot(int num) {

        Boolean primeornot = true;

        if (num <= 1) {
            primeornot = false;
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    primeornot = false;
                    break;
                }
            }
        }

        if (primeornot) {
            System.out.println("It is a prime");
        } else {
            System.out.println("Not a prime");
        }

    }

    public static boolean plaidrome(String s) {

        int n = s.length();

        int left = 0;
        int right = n - 1;

        while (left <= right) {

            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }

        }

        return true;

    }

    public static int fibo(int num) {

        if (num == 0 || num == 1) {
            return num;
        }

        return fibo(num - 1) + fibo(num - 2);

    }

    public static void fibos(int num) {

        for (int i = 0; i <= num; i++) {
            System.out.println(fibo(i));
        }

    }

    public static void main(String[] args) {

    }

}
