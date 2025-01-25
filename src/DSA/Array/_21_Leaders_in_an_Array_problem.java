package DSA.Array;

import java.util.ArrayList;
import java.util.Collections;

public class _21_Leaders_in_an_Array_problem {

    public ArrayList<Integer> leaders(int[] arr) {

        int n = arr.length;

        ArrayList<Integer> result = new ArrayList<>();

        int max = arr[n - 1];

        result.add(max);

        //Come from last and which is the max from the last keep one adding those to result list.
        for (int i = n - 2; i >= 0; i--) {

            if (arr[i] >= max) {
                max = arr[i];
                result.add(arr[i]);
            }

        }

        //Reverse the list.
        Collections.reverse(result);

        return result;

    }

    public static void main(String[] args) {

    }
}
