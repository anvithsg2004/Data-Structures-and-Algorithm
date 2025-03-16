package Top_150;

//💬 Problem Summary:
//A happy number eventually becomes 1 after repeatedly replacing it with the sum of squares of its digits.
//If it enters a loop and never reaches 1, it's not happy.

//🧪 Example 1: n = 19
//1² + 9² = 1 + 81 = 82
//8² + 2² = 64 + 4 = 68
//6² + 8² = 36 + 64 = 100
//1² + 0² + 0² = 1 → Happy! ✅

//🔄 Dry Run: n = 19
//Step	n	    Digits	    Squares Sum	    Seen Set
//1	    19	    1, 9	    1+81 = 82	    {19}
//2	    82	    8, 2	    64+4 = 68	    {19, 82}
//3	    68	    6, 8	    36+64 =100	    {19, 82, 68}
//4	    100	    1, 0, 0	    1+0+0 = 1	    {19, 82, 68,100}
//Output: true ✅

//🧠 Idea:
//We need to detect cycles.
//If we reach 1, it's happy.
//If we see a number again (cycle), it's not happy.
//We can use a HashSet to track seen numbers.

import java.util.HashSet;
import java.util.Set;

public class _18_Happy_Number {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getSumOfSquares(n);
        }

        return n == 1;
    }

    private int getSumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum = sum + (digit * digit);
            num = num / 10;
        }
        return sum;
    }
}
