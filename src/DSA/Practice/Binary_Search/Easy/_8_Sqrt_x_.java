package DSA.Practice.Binary_Search.Easy;

public class _8_Sqrt_x_ {

    public int mySqrt(int x) {

        if (x == 0 || x == 1) {

            return x;

        }

        int low = 1;
        int high = x;
        int ans = 1;

        while (low <= high) {
            int mid = (low + high) / 2;

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
