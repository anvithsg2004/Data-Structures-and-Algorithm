package DSA.Bit_Manipulation;

//In bit, 2^count is equal to 1 << count.

//d << count = d × 2 ^ count

public class _16_Divide_Two_Integers_without_using_Multiplication_and_Division_Operators {

    public static int divide2(int dividend, int divisor) {

        if (dividend == divisor) {
            return 1;
        }

        boolean sign = true;

        if (dividend >= 0 && divisor < 0) {
            sign = false;
        } else if (dividend < 0 && divisor >= 0) {
            sign = false;
        }

        long n = Math.abs(dividend);
        long d = Math.abs(divisor);

        long quotient = 0;

        while (n >= d) {

            int count = 0;

            while (n >= (d << (count + 1))) {
                count = count + 1;
            }

            quotient = quotient + (1L << count);

            n = n - (d << count);

        }

        if (quotient == (1L << 31) && sign) {
            return Integer.MAX_VALUE;
        }

        if (quotient == (1L << 31) && !sign) {
            return Integer.MIN_VALUE;
        }

        return (int) (sign ? quotient : -quotient);

    }


    public int divide(int dividend, int divisor) {

        // Handle an edge case for overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean isNegative = (dividend < 0) != (divisor < 0);

        // Work with absolute values
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        // Perform division by repeated subtraction
        int quotient = 0;
        while (n >= d) {
            n -= d;
            quotient++;
        }

        // Apply the sign to the result
        return isNegative ? -quotient : quotient;

    }
}
