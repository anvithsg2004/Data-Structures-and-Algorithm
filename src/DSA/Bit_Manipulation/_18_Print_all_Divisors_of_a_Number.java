package DSA.Bit_Manipulation;

import java.util.ArrayList;
import java.util.List;

public class _18_Print_all_Divisors_of_a_Number {

    public static List<Integer> print_divisors(int n) {

        List<Integer> result = new ArrayList<>();

        //See here I am using Collection Function which takes some amount of time.
        //So to avoid this use, "i * i <= n"
        //for (int i = 1; i <= Math.sqrt(n); i++) {

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                result.add(i); // Add the smaller divisor

                // Add the corresponding larger divisor if it's not the same as i
                if (i != n / i) {
                    result.add(n / i);
                }
            }
        }

        // Sort the divisors
        result.sort(null);

        // Print the result
        System.out.println(result);


        return result;

    }

}
