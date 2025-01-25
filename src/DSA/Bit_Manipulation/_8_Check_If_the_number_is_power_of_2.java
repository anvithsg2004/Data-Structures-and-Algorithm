package DSA.Bit_Manipulation;

public class _8_Check_If_the_number_is_power_of_2 {

    //Any given number if it is power of 2, then the left number will be 1 and the rest will be 0.
    //The n - 1 number the left number will be 0 and the rest all will be 1.
    //For Example, n = 8 → 1000 and n - 1 = 7 → 0111

    public boolean powerOf2(int n) {

        if (n == 0) {
            return false;
        }

        int number = n & (n - 1);

        if (number == 0) {
            return true;
        } else {
            return false;
        }

    }

}
