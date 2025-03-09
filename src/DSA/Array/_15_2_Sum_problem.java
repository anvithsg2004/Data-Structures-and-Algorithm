package DSA.Array;

import java.util.HashSet;

public class _15_2_Sum_problem {

    //Use Hashing
    public static boolean _2_sum(int[] array, int target) {
        HashSet<Integer> mpp = new HashSet<>();
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int num = array[i];
            //Check this If it has more in the map.
            int moreNeeded = target - num;

            //If yes, then return true.
            if (mpp.contains(moreNeeded)) {
                return true;
            }

            mpp.add(array[i]);
        }

        //Else False.
        return false;
    }
}
