package DSA.Practice.Arrays.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class _13_Number_of_Sub_arrays_With_Odd_Sum {

    //Brute Force Solution
    public int numOfSubarrays(int[] arr) {

        int n = arr.length;

        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + arr[j];
            }
            if (sum % 2 == 1) {
                count++;
            }
        }

        return count;

    }

    //Better Solution
    public static int numOfSubarrays2(int[] arr) {
        int count = 0;

        //Odd - Even = Odd ✅
        //Even - Odd = Odd ✅
        //Even - Even = Even ❌
        //Odd - Odd = Even ❌

        

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        numOfSubarrays2(arr);

    }

}
