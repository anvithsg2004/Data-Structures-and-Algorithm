package DSA.Bit_Manipulation;

public class _4_Set_the_ith_bit {
    public static int setKthBit(int n, int k) {

        int position = 1 << k;

        return n | position;

    }
}
