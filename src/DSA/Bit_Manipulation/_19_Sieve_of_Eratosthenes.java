package DSA.Bit_Manipulation;

//Count Primes
//The technique which I use for calculation of the primes, that is called as Sieve of Eratosthenes.
// It is a fast way to find all prime numbers up to n.

//Create a boolean array isPrime[] of size (n+1), initialized to true.
//isPrime[i] = true means 'i' is prime.
//Start from 2 (first prime) and mark all its multiples as false (not prime).
//Example: Mark 4, 6, 8, 10, ... as false.
//Move to the next number that is still true (prime) and repeat marking its multiples.
//Continue this process until √n, because any non-prime beyond this would have been marked earlier.
//The numbers that remain true are prime numbers.

public class _19_Sieve_of_Eratosthenes {
    public int countPrimes(int n) {

        // Edge case: There are no primes less than 2
        if (n <= 2) return 0;

        int[] prime = new int[n]; // Array size should be n, indices 0 to n-1

        for (int i = 2; i * i < n; i++) { // Outer loop runs while i * i < n
            if (prime[i] == 0) { // If i is prime
                for (int j = i * i; j < n; j = j + i) { // Mark multiples of i as non-prime
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
