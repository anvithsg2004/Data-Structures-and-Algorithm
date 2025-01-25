package DSA.Bit_Manipulation;

//Basics ->
//1) | == Set
//2) ^ == Toggle
//3) & == Check
//4) &~ == Clear

public class _3_Check_if_the_i_th_bit_is_set_or_not {

    //Here Set means 1 and Not Set means 0

    //Here we can use two methods →
    //1) Left Shift of i and AND with N
    //2) Right Shift of N and AND with 1

    public boolean setOrNot(int n, int i) {

        //1)
        boolean leftShift = ((1 << i) & n) != 0;

        //2)
        boolean rightShift = ((n >> i) & 1) != 0;

        if (leftShift && rightShift) {
            return true;
        }

        return false;
    }

}
