package DSA.Bit_Manipulation;

//Instead of multiplying x n times, we use divide and conquer (reducing exponent by half).
//If n is even, we square x and halve n.
//If n is odd, we multiply 'ans' by x and decrease n by 1.

public class _21_Power_Exponentiation {
    public double myPow(double x, int n) {

        double ans = 1;

        long exponent = n; // Use long to handle negative n correctly

        //If n is negative, the exponent variable is set to its absolute value:
        // If exponent is negative, work with its absolute value
        if (exponent < 0) {
            exponent = -exponent;
        }

        while (exponent > 0) {

            if (exponent % 2 == 1) {
                ans = ans * x;
                exponent = exponent - 1;
            } else {
                exponent = exponent / 2;
                x = x * x;
            }

        }

        // If the original n was negative, return reciprocal
        if (n < 0) {
            ans = 1.0 / ans;
        }

        return ans;

    }
}
