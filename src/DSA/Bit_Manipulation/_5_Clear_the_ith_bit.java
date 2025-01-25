package DSA.Bit_Manipulation;

public class _5_Clear_the_ith_bit {
    public static int clearKthBit(int n, int k) {

        int position = 1 << k;

        return n & ~position;

    }
}
