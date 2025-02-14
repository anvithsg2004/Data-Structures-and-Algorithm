package DSA.Binary_Search;

public class _13_Finding_Sqrt_of_a_number_using_Binary_Search {

    public long floorSqrt(long x) {
        long low = 1;
        long high = x;
        long ans = 1;

        //We go from the low to the high in the hope that we get the answer in the middle.

        while (low <= high) {
            long mid = (low + high) / 2;

            //Here we multiply and see whether the mid^2 is lesser than the 'x' given.
            if ((mid * mid) <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
