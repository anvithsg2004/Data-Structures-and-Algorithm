package DSA.Bit_Manipulation;

import java.util.Arrays;

public class _2_Swap_Two_Numbers {
    public static int[] swapTwoNumber(int a, int b) {

        //For example, let us take a = 4 and b = 5;
        //In the first line, it is a ^ b for now keep it like this only.
        //In the second line, it is a ^ b ^ b and now 'b' and 'b' will cancel out.
        //In the third line, b is a and a is a ^ b ^ a.
        //So now a is b.

        a = a ^ b;
        System.out.println(a + " " + b);
        b = a ^ b;
        System.out.println(a + " " + b);
        a = a ^ b;
        System.out.println(a + " " + b);

        return new int[]{a, b};

    }

    public static void main(String[] args) {
        int a = 4;
        int b = 5;

        System.out.println(Arrays.toString(swapTwoNumber(a, b)));
    }

}
