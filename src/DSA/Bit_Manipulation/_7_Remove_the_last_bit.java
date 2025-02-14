package DSA.Bit_Manipulation;

public class _7_Remove_the_last_bit {

    //Remove the right most bit in the number
    //When given n and then If you want to convert to n - 1.
    //For example, n = 56 the decimal is 111000.
    //Now for n - 1 = 55 then decimal is 110111.
    //The last right '1' will convert to '0' and the next will convert '0' to '1'.

    public int removeTheLastSetBit(int n) {
        return n & (n - 1);
    }

}
