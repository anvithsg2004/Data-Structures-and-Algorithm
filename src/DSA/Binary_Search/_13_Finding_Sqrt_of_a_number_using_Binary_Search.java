package DSA.Binary_Search;

public class _13_Finding_Sqrt_of_a_number_using_Binary_Search {

    public long floorSqrt(long x) {
        long low = 1;
        long high = x;
        long ans = 1;

        while (low <= high) {
            long mid = (low + high) / 2;

            if ((mid * mid) <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
