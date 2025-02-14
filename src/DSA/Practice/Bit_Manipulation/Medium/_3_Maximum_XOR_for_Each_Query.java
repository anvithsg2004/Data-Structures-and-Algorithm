package DSA.Practice.Bit_Manipulation.Medium;

import java.util.Arrays;

public class _3_Maximum_XOR_for_Each_Query {
    public int[] getMaximumXor(int[] nums, int maximumBit) {

        int tillK = 1 << maximumBit;

        int[] prefixXOR = new int[nums.length];

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum ^ nums[i];
            prefixXOR[i] = sum;
        }

        System.out.println(Arrays.toString(prefixXOR));

        int[] result = new int[nums.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = prefixXOR[i] ^ (tillK - 1);
        }

        return result;

    }
}
