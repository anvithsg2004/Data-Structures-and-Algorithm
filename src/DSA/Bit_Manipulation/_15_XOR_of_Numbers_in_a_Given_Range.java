package DSA.Bit_Manipulation;

public class _15_XOR_of_Numbers_in_a_Given_Range {

    //Trick :=
    // n % 4 == 0       n
    // n % 4 == 1       1
    // n % 4 == 2       n + 1
    // n % 4 == 3       0

    //Brute Force Solution
    public static int findXOR(int l, int r) {

        int ans = 0;

        for (int i = l; i <= r; i++) {
            ans = ans ^ i;
        }

        return ans;

    }

    //Better Solution
    public static int findXOR2(int l, int r) {

        return help(l - 1) ^ help(r);

    }

    public static int help(int n) {

        if (n % 4 == 1) {
            return 1;
        } else if (n % 4 == 2) {
            return n + 1;
        } else if (n % 4 == 3) {
            return 0;
        } else {
            return n;
        }

    }

}
