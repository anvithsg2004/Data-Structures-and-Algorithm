package DSA.Bit_Manipulation;

//Count Primes
//The technique which I use for calculation of the primes, that is called as Sieve of Eratosthenes.

import java.util.Arrays;

public class _19_Sieve_of_Eratosthenes {

    public int countPrimes(int n) {

        // Edge case: There are no primes less than 2
        if (n <= 2) return 0;

        int[] prime = new int[n]; // Array size should be n, indices 0 to n-1

        for (int i = 2; i * i < n; i++) { // Outer loop runs while i * i < n
            if (prime[i] == 0) { // If i is prime
                for (int j = i * i; j < n; j += i) { // Mark multiples of i as non-prime
                    prime[j] = -1;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) { // Count primes less than n
            if (prime[i] == 0) {
                count++;
            }
        }

        return count;
    }

}
