package DSA.Array.SubArray;

public class _4_Maximum_Product_Subarray {

    //Optimal Solution
    public static int maxProductSubArray(int[] arr) {
        int n = arr.length; //size of an array.

        //Once do the product from the front.
        //Next do it from the back.
        //If in the middle, you get zero, then turn the product to 1.

        int pre = 1, suff = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;
            pre = pre * arr[i];
            suff = suff * arr[n - i - 1];
            ans = Math.max(ans, Math.max(pre, suff));
        }
        return ans;
    }
}
