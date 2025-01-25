package DSA.Bit_Manipulation;

import java.util.ArrayList;
import java.util.List;

public class _17_Print_Prime_Factors_of_a_Number {

    //Better Solution
    public int[] AllPrimeFactors2(int n) {

        List<Integer> result = new ArrayList<>();

        for (int i = 2; i <= n; i++) {

            if (n % i == 0) {

                result.add(i);

                while (n % i == 0) {
                    n = n / i;
                }
            }

        }

        int size = result.size();

        int[] resultInArray = new int[size];

        for (int i = 0; i < size; i++) {

            resultInArray[i] = result.get(i);

        }

        return resultInArray;

    }

    //Brute Force Solution
    public int[] AllPrimeFactors(int n) {

        List<Integer> result = new ArrayList<>();

        // Check factors up to sqrt(n)
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                // If 'i' is a prime factor, add it
                if (primeOrNot(i)) {
                    result.add(i);
                }
                // If 'n / i' is distinct and a prime factor, add it
                int otherFactor = n / i;
                if (otherFactor != i && primeOrNot(otherFactor)) {
                    result.add(otherFactor);
                }
            }
        }

        // If n itself is a prime number, add it
        if (primeOrNot(n)) {
            result.add(n);
        }

        int size = result.size();

        int[] resultInArray = new int[size];

        for (int i = 0; i < size; i++) {
            resultInArray[i] = result.get(i);
        }

        return resultInArray;

    }

    public boolean primeOrNot(int num) {
        if (num <= 1) {
            return false; // 1 and negative numbers are not prime
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
