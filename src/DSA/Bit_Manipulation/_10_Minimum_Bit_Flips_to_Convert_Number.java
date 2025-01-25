package DSA.Bit_Manipulation;

public class _10_Minimum_Bit_Flips_to_Convert_Number {
    public int minBitFlips(int start, int goal) {

        int answer = start ^ goal;

        //Here, For example, start = 4 (100) XOR goal = 7 (111) is 3 (011).

        int count = 0;

        while (answer > 0) {

            count = count + (answer & 1); //This will return 1 if it is odd or 0 is it is even.
            //All odd numbers will have the rightest number will be 1,
            //and if you add 1 to it, then all will become 1;

            answer = answer >> 1; //This is equals to n/2.

        }

        return count;

    }
}
