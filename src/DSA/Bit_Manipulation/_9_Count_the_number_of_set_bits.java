package DSA.Bit_Manipulation;

public class _9_Count_the_number_of_set_bits {

    //In binary search, we use (low + high) / 2,
    //but this is the fastest version is (low + high) >> 1 which is equal to (low + high) / 2.

    //Optimised Solution
    public int countNoOfSet3(int n) {

        int count = 0;

        //For example, here let us take an example of n = 10.
        //Now n = 10 (1010) and n - 1 = 9 (1001), AND of these both are 1000 (8) and n - 1 = 7 (0111)
        //and AND of these both is 0.
        //Now the count is 2.

        while (n != 0) {

            n = n & (n - 1);

            count = count + 1;

        }

        return count;

    }

    //Brute Force Solution
    public int countNoOfSet(int n) {

        int count = 0;

        while (n > 0) {

            if (n % 2 == 1) {
                count = count + 1;
            }

            n = n / 2;

        }

        return count;

    }

    //Better Solution
    public int countNoOfSet2(int n) {

        int count = 0;

        while (n > 0) {

            count = count + (n & 1); //This will return 1 if it is odd or 0 is it is even.
            //All odd numbers will have the rightest number will be 1,
            // and if you add 1 to it, then all will become 1;

            n = n >> 1; //This is equals to n/2.

        }

        return count;

    }

}
