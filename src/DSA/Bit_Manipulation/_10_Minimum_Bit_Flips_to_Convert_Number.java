package DSA.Bit_Manipulation;

public class _10_Minimum_Bit_Flips_to_Convert_Number {
    public int minBitFlips(int start, int goal) {

        int answer = start ^ goal;

        int count = 0;

        for (int i = 0; i <= 31; i++) {

            if ((answer & (1 << i)) == 1) {
                count = count + 1;
            }

        }

        return count;

    }
}
