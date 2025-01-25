package DSA.Practice.Bit_Manipulation.Easy;

import java.util.List;

public class _4_Sum_of_Values_at_Indices_With_K_Set_Bits {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {

        int n = nums.size();

        int[] setNumbers = new int[n];

        for (int i = 0; i < n; i++) {
            setNumbers[i] = countNoOfSet(i);
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (setNumbers[i] == k) {
                sum = sum + nums.get(i);
            }
        }

        return sum;

    }

    public int countNoOfSet(int n) {

        int count = 0;

        while (n != 0) {

            n = n & (n - 1);

            count = count + 1;

        }

        return count;

    }
}
