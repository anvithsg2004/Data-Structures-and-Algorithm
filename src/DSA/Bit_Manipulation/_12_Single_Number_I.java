package DSA.Bit_Manipulation;

public class _12_Single_Number_I {

    //Just Basic XOR Gate formulas.

    public int singleNumber(int[] nums) {

        int n = nums.length;

        int number = nums[0];

        for (int i = 1; i < n; i++) {

            number = number ^ nums[i];

        }

        return number;

    }

}
