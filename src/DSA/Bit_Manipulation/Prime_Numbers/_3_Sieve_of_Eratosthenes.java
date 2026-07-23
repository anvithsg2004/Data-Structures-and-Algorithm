package DSA.Bit_Manipulation.Prime_Numbers;

public class _3_Sieve_of_Eratosthenes {
    public static void printPrimes(int L, int R) {

        boolean[] prime = new boolean[R + 1];

        for (int i = 2; i <= R; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i <= R; i++) {
            if (prime[i]) {
                for (int j = i * 2; j <= R; j = j + i) {
                    prime[j] = false;
                }
            }
        }

        for (int i = Math.max(L, 2); i <= R; i++) {
            if (prime[i]) {
                System.out.println(i);
            }
        }

    }
}
