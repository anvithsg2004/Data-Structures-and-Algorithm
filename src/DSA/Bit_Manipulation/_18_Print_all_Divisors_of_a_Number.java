package DSA.Bit_Manipulation;

import java.util.*;

public class _18_Print_all_Divisors_of_a_Number {
    public static List<Integer> print_divisors(int n) {

        List<Integer> result = new ArrayList<>();

        //See here I am using Collection Function which takes some amount of time.
        //So to avoid this use, "i * i <= n"
        //for (int i = 1; i <= Math.sqrt(n); i++) {
        //i	   n % i == 0?	    Add i?	Add n/i? Updated result
        //1	✅ (36 % 1 == 0)	✅ 1	✅ 36	[1, 36]
        //2	✅ (36 % 2 == 0)	✅ 2	✅ 18	[1, 36, 2, 18]
        //3	✅ (36 % 3 == 0)	✅ 3	✅ 12	[1, 36, 2, 18, 3, 12]
        //4	✅ (36 % 4 == 0)	✅ 4	✅ 9	[1, 36, 2, 18, 3, 12, 4, 9]
        //5	❌ (36 % 5 != 0)	❌	❌	No change
        //6	✅ (36 % 6 == 0)	✅ 6	✅ 6	[1, 36, 2, 18, 3, 12, 4, 9, 6] (only one 6 added)

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
