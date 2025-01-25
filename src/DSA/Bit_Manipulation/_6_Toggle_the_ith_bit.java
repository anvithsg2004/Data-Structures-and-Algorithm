package DSA.Bit_Manipulation;

public class _6_Toggle_the_ith_bit {
    public static int toggleKthBit(int n, int k) {

        // Create a mask with the ith bit set
        int position = 1 << k;

        // Toggle the ith bit using bitwise XOR
        return n ^ position;

    }
}
