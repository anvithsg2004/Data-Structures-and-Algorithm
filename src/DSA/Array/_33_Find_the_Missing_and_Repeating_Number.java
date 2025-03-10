package DSA.Array;

public class _33_Find_the_Missing_and_Repeating_Number {

    //Optimal Code
    public int[] findTwoElement2(int[] arr) {

        long n = arr.length;

        //Actual Values
        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        //What I got.
        long s = 0;
        long s2 = 0;

        for (int i = 0; i < n; i++) {

            s += arr[i];
            s2 += (long) arr[i] * (long) arr[i];

        }

        //(X - Y) (X + Y) = (X^2 - Y^2)

        //S-Sn = X-Y:
        long val1 = s - SN;

        //S2-S2n = X^2-Y^2:
        long val2 = s2 - S2N;

        //Find X+Y = (X^2-Y^2)/(X-Y):
        val2 = val2 / val1;

        //Find X and Y: X = ((X+Y)+(X-Y))/2 and Y = X-(X-Y),
        //Here, X-Y = val1 and X+Y = val2:
        long x = (val1 + val2) / 2;
        long y = x - val1;

        return new int[]{(int) x, (int) y};

    }


    //Hashing
    public int[] findTwoElement(int[] arr) {

        int n = arr.length;

        int[] hash = new int[n];

        for (int i = 0; i < n; i++) {

            hash[arr[i]]++;

        }

        //Find the repeating and missing number:
        int repeating = -1;
        int missing = -1;

        for (int i = 1; i <= n; i++) {

            if (hash[i] == 2) {
                repeating = i;
            } else if (hash[i] == 0) {
                missing = i;
            }

            //If we got the Value then stop ans return the value.
            if (repeating != -1 && missing != -1)
                break;

        }

        int[] ans = {repeating, missing};

        return ans;

    }
}
