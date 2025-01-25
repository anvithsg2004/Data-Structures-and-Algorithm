package DSA.Practice.Bit_Manipulation.Medium;

public class _1_Minimize_XOR {

    public int minimizeXor(int num1, int num2) {

        int setBitsInNum2 = countNoOfSet(num2);

        int result = 0;

        for (int i = 31; i >= 0 && setBitsInNum2 > 0; i--) {
            if ((num1 & (1 << i)) != 0) {
                result = result | (1 << i);
                setBitsInNum2--;
            }
        }

        for (int i = 0; i <= 31 && setBitsInNum2 > 0; i++) {
            if ((result & (1 << i)) == 0) {
                result = result | (1 << i);
                setBitsInNum2--;
            }
        }

        return result;

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
