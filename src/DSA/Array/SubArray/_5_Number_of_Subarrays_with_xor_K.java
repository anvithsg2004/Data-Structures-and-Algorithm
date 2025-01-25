package DSA.Array.SubArray;

import java.util.HashMap;
import java.util.Map;

public class _5_Number_of_Subarrays_with_xor_K {

    //Optimal Solution
    public static int subarraysWithXorK(int[] a, int k) {
        int n = a.length; //size of the given array.
        int xr = 0;
        Map<Integer, Integer> mpp = new HashMap<>(); //declaring the map.
        mpp.put(xr, 1); //setting the value of 0.
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            // prefix XOR till index i:
            xr = xr ^ a[i];

            //By formula: x = xr^k:
            int x = xr ^ k;

            // add the occurrence of xr^k
            // to the count:
            if (mpp.containsKey(x)) {
                cnt += mpp.get(x);
            }

            // Insert the prefix xor till index i
            // into the map:
            if (mpp.containsKey(xr)) {
                mpp.put(xr, mpp.get(xr) + 1);
            } else {
                mpp.put(xr, 1);
            }
        }
        return cnt;
    }


    //Brute Force Solution
    public static int subarraysWithXorK2(int[] a, int k) {
        int n = a.length; //size of the given array.
        int cnt = 0;

        // Step 1: Generating subarrays:
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                //step 2:calculate XOR of all
                // elements:
                int xorr = 0;
                for (int K = i; K <= j; K++) {
                    xorr = xorr ^ a[K];
                }

                // step 3:check XOR and count:
                if (xorr == k) cnt++;
            }
        }
        return cnt;
    }
}
