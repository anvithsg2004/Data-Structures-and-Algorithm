package DSA.Practice.Bit_Manipulation.Easy;

public class _3_XOR_Operation_in_an_Array {
    public int xorOperation(int n, int start) {

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = start + (2 * i);
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum = sum ^ result[i];

        }

        return sum;

    }
}
