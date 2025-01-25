package DSA.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _20_Next_Permutation {

    public ArrayList<Integer> nextPermutation(int[] nums) {

        ArrayList<Integer> result = new ArrayList<>();
        for (int num : nums) {
            result.add(num);
        }

        int n = result.size();

        //Now find the greatest number index in the array given.
        int ind = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (result.get(i) < result.get(i + 1)) {
                ind = i;
                break;
            }
        }

        //If there is no greatest then just reverse the array and return it.
        if (ind == -1) {
            Collections.reverse(result);
            return result;
        }

        //Find the next greater element and swap it with arr[ind]:
        for (int i = n - 1; i > ind; i--) {

            if (result.get(i) > result.get(ind)) {

                int temp = result.get(i);
                result.set(i, result.get(ind));
                result.set(ind, temp);
                break;

            }

        }

        // Step 3: reverse the right half:
        List<Integer> sublist = result.subList(ind + 1, n);
        Collections.reverse(sublist);

        return result;

    }

    public static void main(String[] args) {

    }
}
