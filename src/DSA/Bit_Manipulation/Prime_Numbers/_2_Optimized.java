package DSA.Bit_Manipulation.Prime_Numbers;

public class _2_Optimized {
    public boolean isPrime(int n) {

        if (n <= 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;

    }
}
